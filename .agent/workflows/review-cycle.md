---
description: Implement code, run automated Codex review, fix issues, repeat up to 5 times
---

# Codex Review Cycle Workflow

Use this workflow whenever you implement a non-trivial feature, fix, or refactor.
The goal is to produce high-quality, reviewed code automatically using Codex CLI as a reviewer.

---

## Prerequisites

Before starting this workflow, ensure:
1. Codex CLI is installed: `npm i -g @openai/codex`
2. Codex is authenticated: `codex auth login`
3. The skill script exists at `.agent/skills/codex-system/scripts/ask_codex.ps1`

---

## Workflow Steps

### Step 1 — Implement the Code

Write the code to fulfill the user's request using your normal implementation process.
- Read relevant existing files first to understand context
- Follow existing patterns and conventions
- Add meaningful comments

---

### Step 2 — Prepare the Review Prompt

After implementing, build a review prompt that describes:
- What you implemented and why
- Which files were changed
- Any design decisions or tradeoffs
- Specific areas you're uncertain about

Example prompt template:
```
You are a senior code reviewer. Review the following code for:
1. Correctness and logic errors
2. Security vulnerabilities
3. Performance issues
4. Code style and readability
5. Edge cases that are not handled

Implementation summary: [describe what was implemented]

Please respond with:
- ISSUES: List each issue with severity (CRITICAL / MAJOR / MINOR)
- SUGGESTIONS: Optional improvements
- VERDICT: APPROVED or NEEDS_CHANGES
```

---

### Step 3 — Call Codex for Review

Run the review script for each changed file:

```powershell
.\.agent\skills\codex-system\scripts\ask_codex.ps1 `
  -Prompt "[your review prompt from Step 2]" `
  -FilePath "[path to the changed file]"
```

Read the output saved at `.agent/skills/codex-system/last_review.txt`.

---

### Step 4 — Parse the Review Result

After Codex responds, check the VERDICT:

- **APPROVED** → Proceed to Step 6 (done!)
- **NEEDS_CHANGES** → Proceed to Step 5

Also check for any CRITICAL or MAJOR issues that must be fixed before moving on.

---

### Step 5 — Fix Issues and Repeat

For each CRITICAL or MAJOR issue identified by Codex:
1. Read the issue description carefully
2. Apply the fix to the affected file
3. Document what you changed and why
4. Increment the iteration counter

**Repeat from Step 3** with the updated file.

> ⚠️ Maximum 5 iterations. If issues persist after 5 cycles, stop and report the remaining issues to the user for manual review.

---

### Step 6 — Finalize

Once Codex gives APPROVED (or after 5 cycles):
1. Summarize what was implemented
2. List all issues Codex found and how they were fixed
3. Report any unresolved issues to the user
4. Commit changes if using git

---

## Example Usage

When a user says "implement X and review it with Codex", follow this workflow:

```
Iteration 1: Implement → Review → NEEDS_CHANGES (2 MAJOR issues found) → Fix
Iteration 2: Review → NEEDS_CHANGES (1 MINOR issue) → Fix
Iteration 3: Review → APPROVED ✅
```

Report: "Implemented X. Codex found 3 issues over 2 review cycles, all fixed. Final review: APPROVED."

---

## Multi-File Reviews

For changes spanning multiple files, run the review script once per file and aggregate results before applying fixes:

```powershell
# Review each changed file
.\.agent\skills\codex-system\scripts\ask_codex.ps1 -Prompt "[prompt]" -FilePath "File1.java"
.\.agent\skills\codex-system\scripts\ask_codex.ps1 -Prompt "[prompt]" -FilePath "File2.java"
```

Then fix all issues together and re-review all files in the next iteration.
