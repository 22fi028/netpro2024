## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

課題の詳細
ファイル
クライアント:MarketClient.java
サーバー:MarketServer.java
受け渡しに使うクラス:Product.java

動作
クライアントが欲しい商品の名前と数を送ると、サーバーが名前を頼んだ個数繋げて返すプログラム
また、サーバー側がサービスとして0~3個増やしてくれる。
例）
クライアント「商品名:apple, 個数:3」
サーバー「一つサービスして、apple apple apple apple」


