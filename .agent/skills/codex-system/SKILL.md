---
name: codex-review
description: Delegates code review and complex reasoning tasks to OpenAI Codex CLI. Use this skill when you need an automated second opinion on code quality, security, correctness, or architecture decisions.
---

# Codex Review Skill

This skill enables Antigravity to consult OpenAI Codex CLI for automated code reviews and deep reasoning tasks.

## When to Use This Skill

- After implementing a significant feature or fix
- When unsure about code correctness or security
- For complex algorithmic reasoning
- As part of the review-cycle workflow

## How to Use

Call the helper script to send a prompt to Codex and capture its response:

```powershell
.\.agent\skills\codex-system\scripts\ask_codex.ps1 -Prompt "Review the following code for bugs and improvements: ..." -FilePath "path/to/file.java"
```

The script will:
1. Check that Codex CLI is installed and authenticated
2. Send the prompt (with optional file content) to Codex
3. Write the response to `.agent/skills/codex-system/last_review.txt`
4. Print the response to stdout for the agent to read

## Parameters

| Parameter  | Required | Description                                              |
|------------|----------|----------------------------------------------------------|
| `-Prompt`  | Yes      | The review question or instruction                       |
| `-FilePath`| No       | Absolute or relative path to a file to include as context|
| `-Model`   | No       | Codex model to use (default: `codex-mini-latest`)        |

## Output

The Codex response is saved to:
```
.agent/skills/codex-system/last_review.txt
```

Read this file after each call to inspect Codex's feedback.

## Setup Requirements

1. Node.js 22+ installed
2. Codex CLI installed: `npm i -g @openai/codex`
3. Codex authenticated: `codex auth login`
4. (Windows) Paths configured in `ask_codex.ps1` if `codex` is not on PATH

## Review-Cycle Workflow

See `.agent/workflows/review-cycle.md` for the full automated implement → review → fix loop.
