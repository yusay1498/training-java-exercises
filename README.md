# Java Coding Exercises

Javaでアルゴリズムとデータ構造を練習するための、一般向けコーディング問題集です。

## 学習目標

- 1問あたりの目安時間を20～30分とし、60分で2～3問に取り組む練習を想定します。
- 対象分野は配列・リスト、ハッシュマップ、スタック・キュー、グラフ探索（DFS/BFS）、ソート・探索、動的計画法です。
- 問題の難しさはLeetCode Easy～Medium相当を目安に設計します。これは教材上の目標であり、AtCoderのレートや問題難易度との公式な換算を示すものではありません。

AtCoderの色は参加者レートの区分です。レート800前後は緑、水色は1200～1599です。そのため「AtCoder水色（レート800前後）」とは表現せず、必要に応じて参加者レートと問題の難しさを分けて記述します。詳細は[要件・設計方針](docs/requirements.md)を参照してください。

## 実装時の前提

- Java 25
- Maven Wrapper 3.3.4（Maven 3.9.16を自動取得）

各問題は独立したMavenモジュールです。解答するときは `src/main/java/Main.java` を編集します。模範解答は `src/main/java/reference/ReferenceMain.java` に分け、JUnitテストと実行可能JARは参照解答を検証します。

ルートから全問題をテストするには `./mvnw test`、個別の問題モジュールをテストするには `./mvnw -pl problems/arrays/left-rotate test` を実行します。

学習者の `Main.java` を実行するときは、先にコンパイルしてからクラスを指定します。雛形のままでは `solve` が未実装のため、実装後に実行してください。

```sh
./mvnw -pl problems/arrays/left-rotate compile
java -cp problems/arrays/left-rotate/target/classes Main < input.txt
```

模範解答の実行可能JARは `./mvnw -pl problems/arrays/left-rotate package` で作成し、次のように実行できます。JUnitテストも模範解答を対象にしています。

```sh
java -jar problems/arrays/left-rotate/target/array-left-rotate-1.0-SNAPSHOT.jar
```

## 現在の構成と今後の予定

ルートPOMはMavenの集約POMで、問題ごとに独立したMavenモジュールを登録します。各モジュールには問題文、解説、実行可能な模範解答、テストを配置し、問題ごとに独立した `Main` クラスを使用します。

```text
problems/
  _template/
    problem.md
    solution.md
    pom.xml
  arrays/
    left-rotate/
      pom.xml
      problem.md
      solution.md
      src/
        main/java/
          Main.java
          reference/ReferenceMain.java
        test/java/
          reference/ReferenceMainTest.java
    range-sum/
      pom.xml
      problem.md
      solution.md
      src/
        main/java/
          Main.java
          reference/ReferenceMain.java
        test/java/
          reference/ReferenceMainTest.java
  hash-map/
    two-sum/
      pom.xml
      problem.md
      solution.md
      src/
        main/java/
          Main.java
          reference/ReferenceMain.java
        test/java/
          reference/ReferenceMainTest.java
  stack-queue/
    two-stack-queue/
      pom.xml
      problem.md
      solution.md
      src/
        main/java/
          Main.java
          reference/ReferenceMain.java
        test/java/
          reference/ReferenceMainTest.java
  graph-search/
    shortest-path/
      pom.xml
      problem.md
      solution.md
      src/
        main/java/
          Main.java
          reference/ReferenceMain.java
        test/java/
          reference/ReferenceMainTest.java
  sorting-searching/
    first-occurrence/
      pom.xml
      problem.md
      solution.md
      src/
        main/java/
          Main.java
          reference/ReferenceMain.java
        test/java/
          reference/ReferenceMainTest.java
  dynamic-programming/
    minimum-coins/
      pom.xml
      problem.md
      solution.md
      src/
        main/java/
          Main.java
          reference/ReferenceMain.java
        test/java/
          reference/ReferenceMainTest.java
    stair-steps/
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

## 問題の追加

1. `problems/_template/` を `problems/<category>/<problem-id>/` へ複製します。
2. 複製先の `pom.xml` で、親POMの `<relativePath>` を `../../../pom.xml` に変更し、`<artifactId>` を問題固有の値に変更します。例えば問題IDが `array-two-sum` なら、`array-two-sum` とします。
3. `problem.md` に問題文・入出力・制約・サンプルを、`solution.md` に解法方針・正当性・計算量を記入します。
4. 学習者が編集する `src/main/java/Main.java` と、検証済み模範解答 `src/main/java/reference/ReferenceMain.java` を分けます。参照解答のテストは `src/test/java/reference/ReferenceMainTest.java` に置きます。
5. ルートの `pom.xml` の `<modules>` に、作成した `problems/<category>/<problem-id>` を登録します。

問題を解く際は `problem.md` を先に読み、解答後に `solution.md` と模範解答を参照してください。解答・解説は学習用の一例であり、別の正しい解法もあります。
