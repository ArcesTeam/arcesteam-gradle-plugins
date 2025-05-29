# 📦 template-project

> **ArcesTeam 内部通用模板仓库**
> 作为 Arces 项目的项目模板体系的最小通用子集，适用于构建其他更复杂模板仓库（如
`template-gradle-project`、`template-gradle-neoforge-project`）的基础模板。

---

## 📘 项目简介

`template-project` 是一个适用于团队内项目起步的通用基础模板，主要提供：

- 🌱 最基本的项目文件结构；
- ⚙️ GitHub 功能模块配置（Issue、PR、CI）；
- 📄 常见文档与规范；
- 🧰 编辑器与 Git 工具支持配置；

该模板本身并不包含任何构建工具或语言绑定，推荐在此基础上构建更具语义与功能的上层模板仓库，如：

- [
  `template-gradle-project`](https://github.com/ArcesTeam/template-gradle-project) —
  通用 Gradle 项目模板
- [
  `template-gradle-neoforge-project`](https://github.com/ArcesTeam/template-gradle-neoforge-project) —
  NeoForge 模组项目模板

---

## 🚀 项目特性

- 🎯 **标准结构**：提供清晰、规范的仓库结构，统一团队开发风格；
- 📦 **文档齐全**：集成
  [README](https://github.com/ArcesTeam/template-project/blob/main/README-template.md)、
  [LICENSE](https://github.com/ArcesTeam/template-project/blob/main/LICENSE)、
  [CHANGELOG](https://github.com/ArcesTeam/template-project/blob/main/CHANGELOG/)、
  [CONTRIBUTING](https://github.com/ArcesTeam/template-project/blob/main/.github/CONTRIBUTING.md)、
  [CODE_OF_CONDUCT](https://github.com/ArcesTeam/template-project/blob/main/.github/CODE_OF_CONDUCT.md)
  等基础文档；
- ⚙️ **自动化配置**：预配置 GitHub Workflows、PR/Issue 模板，支持 CI/CD 起步；
- ✨ **编辑器支持**：提供通用的
  `.editorconfig` 与
  `.idea/copyright`（用于 ArcesTeam 项目）；
- 🛡️ **社区规范**：集成安全报告指引与社区行为准则，降低协作风险。

---

## 🧩 项目结构

``` text
项目结构总览
.
├── .github/                         → GitHub 专用配置目录
│   ├── DISCUSSION_TEMPLATE/         → 配置 Discussions 模板
│   ├── ISSUE_TEMPLATE/              → 配置 Issues 模板
│   ├── lang/                        → 多语言支持目录
│   ├── PULL_REQUEST_TEMPLATE/       → 配置 Pull Request 模板
│   ├── WORKFLOWS/                   → GitHub Actions 自动化工作流
│   ├── CODE_OF_CONDUCT.md           → 社区行为准则（Code of Conduct）
│   └── CONTRIBUTING.md              → 贡献指南（Contribution Guide）
├── .idea/
│   └── copyright                    → JetBrains IDE 版权信息配置（仅限 Arces 团队）
├── .editorconfig                    → 通用编辑器风格规范配置
├── .gitattributes                   → Git 属性配置（如文本归一化）
├── .gitignore                       → Git 忽略文件列表
├── CHANGELOG.md                     → 项目更新日志（可扩展为目录式）
├── LICENSE                          → MIT 许可协议
├── NOTICE                           → 附加授权或声明信息
├── SECURITY.md                      → 安全问题报告规范
├── README.md                        → 本项目文档入口
└── README-template.md               → 可复用的 README 模板
```

---

## ⚡️ 快速开始

### 🧱 从模板创建新仓库

点击 GitHub
界面右上角的 [Use this template](https://github.com/ArcesTeam/template-project/generate)
按钮，即可基于此模板创建新的仓库。

- 进行必要的项目名称替换 例: `{{project-name}}`->`your-repo-name`

更为详细地操作流程可以参考 GitHub
官方文档 [从模板创建仓库](https://docs.github.com/zh/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template)

### 🛠️ 使用 GitHub CLI 创建

```bash
gh repo create <your-repo-name> --template ArcesTeam/template-project
```

- 进行必要的项目名称替换 例: `{{project-name}}`->`your-repo-name`

更为详细地使用流程可以参考 GitHub CLI
官方文档 [gh repo create](https://cli.github.com/manual/gh_repo_create)

> 💡 需要安装 GitHub CLI 工具

## 🧭 使用建议

你可以将此模板用作：

- 💼 团队级别的项目起始模板；
- 🚀 快速搭建带有标准化配置的新仓库；
- 📁 搭建更复杂模板的基础依赖（推荐使用 [
  `template-gradle-project`](https://github.com/ArcesTeam/template-gradle-project)
  进行扩展）；

---

## 📄 License

本模板项目采用 [MIT License](https://github.com/ArcesTeam/template-project/blob/main/LICENSE)。

---

## 📣 联系我们

此项目由 [ArcesTeam](https://github.com/ArcesTeam) 维护，欢迎提出改进建议或提交
PR

---

## ✅ 你还可以：

- 🔍 查看 [
  `template-gradle-project`](https://github.com/ArcesTeam/template-gradle-project)
  获取构建逻辑支持；
- 🧪 使用此模板测试构建标准化结构；
- 💬 在 [Discussions](https://github.com/orgs/ArcesTeam/discussions)
  中提交问题或反馈模板建议；

---
