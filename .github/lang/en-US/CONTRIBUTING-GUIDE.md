# Development Guide & Workflow

<p align="right">
  <a href="https://github.com/ArcesTeam/{{project-name}}/blob/main/.github/lang/zh-CN/CONTRIBUTING-GUIDE.md" title="简体中文">CN 简体中文</a> &nbsp;|&nbsp;
  <strong>EN English</strong>
</p>

This document provides unified standards for project development and applies to
all developers and contributors. Please strictly follow the conventions below
for development, submission, and collaboration.

## Issue Types & Naming Conventions

| IssueTypes    | Issue Prefix | Branch Naming           | Commit Example                    | PR Specification                                       | Description                 |
|---------------|--------------|-------------------------|-----------------------------------|--------------------------------------------------------|-----------------------------|
| Bug           | [Bug]        | Bug/<IssueId>-[<desc>]  | [Bug] ref #<IssueId> : <details>  | [Bug] ref #<IssueId> : <desc> ... [closed #<IssueId>]  | Bug fix                     |
| Performance   | [Perf]       | Perf/<IssueId>-[<desc>] | [Perf] ref #<IssueId> : <details> | [Perf] ref #<IssueId> : <desc> ... [closed #<IssueId>] | Performance optimization    |
| Question      | [Question]   | N/A                     | N/A                               | N/A                                                    | For questions only          |
| Enhancement   | [Enh]        | Enh/<IssueId>-[<desc>]  | [Enh] ref #<IssueId> : <details>  | [Enh] ref #<IssueId> : <desc> ... [closed #<IssueId>]  | Feature enhancement         |
| Feature       | [Feat]       | Feat/<IssueId>-[<desc>] | [Feat] ref #<IssueId> : <details> | [Feat] ref #<IssueId> : <desc> ... [closed #<IssueId>] | New feature                 |
| Documentation | [Doc]        | Doc/<IssueId>-[<desc>]  | [Doc] ref #<IssueId> : <details>  | [Doc] ref #<IssueId> : <desc> ... [closed #<IssueId>]  | Docs/comments/translation   |
| Other         | [Other]      | N/A                     | N/A                               | N/A                                                    | For archiving/uncategorized |
| Dev           | [Dev]        | Dev/<IssueId>-[<desc>]  | [Dev] ref #<IssueId> : <details>  | [Dev] ref #<IssueId> : <desc> ... [closed #<IssueId>]  | Dev process/scripts/CI/CD   |

- Issues must use the appropriate type and template, and titles must include the
  corresponding prefix.
- Except for Question/Other types, all development activities must be linked to
  an Issue.

## Branch Management

- Branch naming format: `<Type>/<IssueId>-<desc>`
  - Example: `Bug/1234-fix-crash`
- All development branches must be based on the main branch (main/master).
- Keep branches up to date with the main branch before merging.

## Commit Message Specification

- Format: `[Type] ref #<IssueId> : <details>`
  - Example: `[Bug] ref #1234 : Fix crash on startup`
- Each commit should focus on a single issue; avoid mixed commits.

## PR Information & Process

- PR titles and descriptions must include the corresponding Issue information,
  same format as commit messages.
- PRs must be linked to the corresponding Issue and automatically close it upon
  merge (e.g., `[closed #<IssueId>]`).
- All PRs must pass automated checks and code review.

## Label Specification

- Issues/PRs must use appropriate labels (e.g., bug, enhancement, documentation,
  etc.).
- Labels are used to track priority, type, progress, etc.

## Linking & Reference Conventions

- All references to Issues, PRs, and commits must use the `#<IssueId>` format.
- Use full URLs for external documents, discussions, etc.

## Other Conventions

- All development activities must comply with
  the [Code of Conduct](https://github.com/ArcesTeam/{{project-name}}/blob/main/.github/lang/en-US/CODE_OF_CONDUCT.md)
  and [Security Policy](https://github.com/ArcesTeam/{{project-name}}/blob/main/.github/lang/en-US/SECURITY.md).
- For code style, formatting, testing, etc., refer to relevant project documents
  or configurations.

If you have any questions, please contact the maintainers via Issue or
Discussions.
