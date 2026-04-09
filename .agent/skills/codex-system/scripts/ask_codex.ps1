<#
.SYNOPSIS
    Calls OpenAI Codex CLI for automated code review / reasoning.

.DESCRIPTION
    This script is used by Antigravity agents to delegate code review
    and complex reasoning tasks to OpenAI Codex CLI. It sends a prompt
    (optionally with file content) to Codex and saves the response.

.PARAMETER Prompt
    The review question or instruction to send to Codex.

.PARAMETER FilePath
    (Optional) Path to a source file whose content will be appended to the prompt.

.PARAMETER Model
    (Optional) Codex model to use. Default: codex-mini-latest

.EXAMPLE
    .\ask_codex.ps1 -Prompt "Review this Java file for bugs" -FilePath "Calculate.java"

.NOTES
    Requirements:
      - Node.js 22+ on PATH (or set $NodePath below)
      - Codex CLI installed: npm i -g @openai/codex
      - Codex authenticated: codex auth login
#>

param(
    [Parameter(Mandatory = $true)]
    [string]$Prompt,

    [Parameter(Mandatory = $false)]
    [string]$FilePath = "",

    [Parameter(Mandatory = $false)]
    [string]$Model = "codex-mini-latest"
)

# ─── PATH CONFIGURATION ────────────────────────────────────────────────────────
# If `codex` is not on your system PATH, set the full paths below.
# Run `where.exe codex` and `where.exe node` in PowerShell to find them.
$NodePath  = "node"      # e.g. "C:\Program Files\nodejs\node.exe"
$CodexPath = "codex"     # e.g. "C:\Users\KETAN\AppData\Roaming\npm\codex.cmd"
# ───────────────────────────────────────────────────────────────────────────────

$OutputFile = Join-Path $PSScriptRoot "..\last_review.txt"

# ── 1. Verify Codex is available ───────────────────────────────────────────────
$codexExists = $null
try {
    $codexExists = Get-Command $CodexPath -ErrorAction Stop
} catch {
    Write-Error "❌ Codex CLI not found at '$CodexPath'."
    Write-Error "   Install it with: npm i -g @openai/codex"
    Write-Error "   Then authenticate: codex auth login"
    exit 1
}

# ── 2. Build the full prompt ───────────────────────────────────────────────────
$fullPrompt = $Prompt

if ($FilePath -ne "" -and (Test-Path $FilePath)) {
    $fileContent = Get-Content -Path $FilePath -Raw
    $fileName    = Split-Path $FilePath -Leaf
    $fullPrompt  = @"
$Prompt

--- FILE: $fileName ---
$fileContent
--- END OF FILE ---
"@
    Write-Host "📄 Including file: $FilePath"
} elseif ($FilePath -ne "") {
    Write-Warning "⚠️  File not found: $FilePath — sending prompt without file content."
}

Write-Host "🤖 Consulting Codex ($Model)..."

# ── 3. Call Codex CLI ──────────────────────────────────────────────────────────
# Codex CLI is called in non-interactive / quiet mode.
# We pass the prompt via stdin and capture stdout.
$response = $fullPrompt | & $CodexPath `
    --model $Model `
    --quiet `
    --no-ansi `
    2>&1

$exitCode = $LASTEXITCODE

# ── 4. Handle result ───────────────────────────────────────────────────────────
if ($exitCode -ne 0) {
    Write-Error "❌ Codex exited with code $exitCode."
    Write-Error $response
    exit $exitCode
}

# Save to file for agent to read
$response | Out-File -FilePath $OutputFile -Encoding UTF8 -Force

Write-Host ""
Write-Host "═══════════════════════════════════════════════════"
Write-Host "  CODEX REVIEW RESULT"
Write-Host "═══════════════════════════════════════════════════"
Write-Host $response
Write-Host "═══════════════════════════════════════════════════"
Write-Host "✅ Review saved to: $OutputFile"

exit 0
