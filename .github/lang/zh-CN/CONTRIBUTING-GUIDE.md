# 开发规约与流程指南

<p align="right">
  <strong>CN 简体中文</strong> &nbsp;|&nbsp;
  <a href="https://github.com/ArcesTeam/arcesteam-gradle-plugins/blob/main/.github/lang/en-US/CONTRIBUTING-GUIDE.md" title="English">EN English</a>
</p>

本文件为项目开发的统一规范，适用于所有开发成员及贡献者。请严格遵循以下约定进行开发、提交与协作。

## Issue 类型与命名规范

| IssueTypes    | Issue前缀    | 分支命名                    | 提交信息示例                         | PR 信息规范                                                | 说明            |
|---------------|------------|-------------------------|--------------------------------|--------------------------------------------------------|---------------|
| Bug           | [Bug]      | Bug/<IssueId>-[<简要描述>]  | [Bug] ref #<IssueId> : <详细描述>  | [Bug] ref #<IssueId> : <简要描述> ... [closed #<IssueId>]  | 问题修复          |
| Performance   | [Perf]     | Perf/<IssueId>-[<简要描述>] | [Perf] ref #<IssueId> : <详细描述> | [Perf] ref #<IssueId> : <简要描述> ... [closed #<IssueId>] | 性能优化          |
| Question      | [Question] | 无                       | 无                              | 无                                                      | 仅用于疑问，暂不处理    |
| Enhancement   | [Enh]      | Enh/<IssueId>-[<简要描述>]  | [Enh] ref #<IssueId> : <详细描述>  | [Enh] ref #<IssueId> : <简要描述> ... [closed #<IssueId>]  | 功能增强          |
| Feature       | [Feat]     | Feat/<IssueId>-[<简要描述>] | [Feat] ref #<IssueId> : <详细描述> | [Feat] ref #<IssueId> : <简要描述> ... [closed #<IssueId>] | 新功能           |
| Documentation | [Doc]      | Doc/<IssueId>-[<简要描述>]  | [Doc] ref #<IssueId> : <详细描述>  | [Doc] ref #<IssueId> : <简要描述> ... [closed #<IssueId>]  | 文档/注释/翻译      |
| Other         | [Other]    | 无                       | 无                              | 无                                                      | 仅用于归档/未分类     |
| Dev           | [Dev]      | Dev/<IssueId>-[<简要描述>]  | [Dev] ref #<IssueId> : <详细描述>  | [Dev] ref #<IssueId> : <简要描述> ... [closed #<IssueId>]  | 开发流程/脚本/CI/CD |

- Issue 必须选择合适的类型与模板，标题需包含对应前缀。
- 除 Question/Other 类型外，所有开发活动均需与 Issue 绑定。

## 分支管理规范

- 分支命名格式：`<类型>/<IssueId>-<简要描述>`
  - 例：`Bug/1234-修复崩溃问题`
- 所有开发分支均需从主分支（main/master）拉取。
- 合并前需保持分支与主分支同步。

## 提交信息规范

- 格式：`[类型] ref #<IssueId> : <详细描述>`
  - 例：`[Bug] ref #1234 : 修复启动时崩溃`
- 每次提交应聚焦单一问题，避免混合提交。

## PR 信息与流程

- PR 标题与描述需包含对应 Issue 信息，格式同提交信息。
- PR 必须关联对应 Issue，并在合并时自动关闭（如 `[closed #<IssueId>]`）。
- 所有 PR 需通过自动化检查与代码审核。

## 标签（Label）规范

- Issue/PR 必须根据内容选择合适的标签（如 bug、enhancement、documentation 等）。
- 标签用于追踪优先级、类型、进度等。

## 链接与引用约定

- 所有 Issue、PR、提交信息中的引用均需使用 `#<IssueId>` 形式。
- 外部文档、讨论等请使用完整 URL。

## 其他约定

-

所有开发活动需遵守 [行为准则](https://github.com/ArcesTeam/arcesteam-gradle-plugins/blob/main/.github/lang/zh-CN/CODE_OF_CONDUCT.md)
与 [安全政策](https://github.com/ArcesTeam/arcesteam-gradle-plugins/blob/main/.github/lang/zh-CN/SECURITY.md)。
- 代码风格、格式化、测试等请参考项目内相关文档或配置。

如有疑问，请通过 Issue 或 Discussions 联系维护团队。
