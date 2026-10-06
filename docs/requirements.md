# 要件・設計方針

## 目的

Javaによるアルゴリズムとデータ構造の一般的な練習問題を提供します。公式問題、出題内容、制限時間、難易度を再現・保証するものではありません。

## 対象者と練習目標

- コーディングテスト対策をしたい学習者
- 1問あたり20～30分を目安とし、60分で2～3問に取り組む練習
- 問題の設計目安はLeetCode Easy～Medium相当

練習時間と難易度はこの教材の設計目標です。特定の採用試験で確認された条件ではありません。また、各プラットフォームの難易度を同じ尺度として換算するものではありません。

## 対象分野

- 配列・リスト操作
- ハッシュマップ
- スタック・キュー
- グラフ探索（DFS/BFS）
- ソート・探索
- 動的計画法

## 問題に含める情報

各問題文には、タイトル、想定解答時間、目安難易度、分野、問題、入力形式、出力形式、制約、サンプルを含めます。必要な問題には補足も追加します。

各解説には、解法方針、正当性の説明、時間・空間計算量、実装上の注意を含めます。実行可能な模範解答はJavaコードとして別に管理し、解説との不一致を避けます。

## 独立性と構成

問題ごとに問題文、解説、模範解答、テストを分け、他の問題に依存せずに実行・検証できるMaven子モジュールとして管理します。ルートPOMは集約POMとし、各問題で独立した `Main` クラス名を使えるようにします。

```text
problems/<category>/<problem-id>/
  pom.xml
  problem.md
  solution.md
  src/
    main/java/
      Main.java
      reference/ReferenceMain.java
    test/java/
      reference/ReferenceMainTest.java
```

`Main.java` は学習者が回答を記入するための雛形です。実行・テスト可能な模範解答は `reference.ReferenceMain` に分離し、解説Markdownにはコード本体を埋め込みません。

`problems/_template/` は新しい問題モジュールを作るための雛形であり、Maven reactorには含めません。実問題の子モジュールを追加したときは、ルートPOMの `<modules>` に登録します。

テンプレートPOMの親相対パスは、テンプレート配置の `problems/_template/` からルートを指す `../../pom.xml` です。これを `problems/<category>/<problem-id>/` に複製した後は、ルートを指す `../../../pom.xml` に必ず変更します。また、Maven座標の重複を避けるため、子POMの `<artifactId>` を問題ごとに一意な値へ変更します。

## 難易度表記に関する注意

AtCoderのレート色は参加者のレート区分を表し、個々の問題難易度との公式換算ではありません。AtCoder公式の区分では、レート800～1199が緑、1200～1599が水色、1600～1999が青です。したがって「水色（レート800前後）」という組み合わせは使いません。本教材ではプラットフォーム間の換算を断定せず、問題ごとに設計上の目安を記載します。

## 参考

- [AtCoder Rating](https://atcoder.jp/about/ratings)
- [LeetCode Problemset](https://leetcode.com/problemset/)
- [Maven Guide: Multiple Modules](https://maven.apache.org/guides/mini/guide-multiple-modules.html)
- [Maven Model Reference: parent.relativePath](https://maven.apache.org/ref/current/maven-model/maven.html#class_parent)
