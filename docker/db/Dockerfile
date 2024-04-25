# ベースイメージを指定
FROM eclipse-temurin:17

# H2 DatabaseのダウンロードURLを指定
ARG H2_VERSION=1.4.200
ARG H2_DOWNLOAD_URL=https://repo1.maven.org/maven2/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar

# H2 DatabaseのJARファイルをダウンロードしてコンテナにコピー
# ADD ダウンロード元URL ダウンロード(保存)先
ADD ${H2_DOWNLOAD_URL} /opt/h2/h2.jar

# H2 Databaseの実行コマンドを指定
# 「Dockerコンテナ内でH2 Databaseのサーバーを起動し、TCPおよびWebコンソールのアクセスを可能にします」
# -cp "/opt/h2/h2.jar": クラスパスを指定します。ここでは、H2 DatabaseのJARファイルがある場所を指定しています。
# org.h2.tools.Server: H2 Databaseのサーバーを実行するためのメインクラスです。
# -tcp: TCPプロトコルを使用してデータベースへの接続を許可します。
# -web: Webコンソールを有効にします。
# -webAllowOthers: 他のユーザーがWebコンソールにアクセスできるようにします。
# -tcpAllowOthers: 他のユーザーがTCPプロトコルを使用してデータベースに接続できるようにします。
CMD ["java", "-cp", "/opt/h2/h2.jar", "org.h2.tools.Server", "-tcp", "-web", "-webAllowOthers", "-tcpAllowOthers"]
