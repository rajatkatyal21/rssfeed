1. There are few APIs created for the Add, delete, patch new feeds. 
2. Instead of storing the data in files. I have used in-memmory database(h2) for storing the data.
3. For excluding the keywords. I have made it configurable in the application.yml file. Whatever keyword we want to exclude
4. we can add it comma separated and those will not be included in description and title. 
5. Information about the APIs are present in the below URL when the application is started at local env at 8080 port
6. http://localhost:8080/rssfeed/swagger-ui.html#/
7. There seem to be bug in swagger with the XML requests. So, Please consider the below request for the post.
8. 
````
curl -X POST \
  http://localhost:8080/rssfeed/channel/ \
  -H 'Accept: application/xml' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/xml' \
  -H 'Postman-Token: 1f9e4290-bb12-a2df-7de2-6ccf6772219e' \
  -d '<channel>
    <title>UZABASE Tech Blog</title>
    <link>http://tech.uzabase.com/</link>
    <description>株式会社ユーザベースの技術チームブログです。 主に週次の持ち回りLTやセミナー・イベント情報について書きます。</description>
    <lastBuildDate>Fri, 13 Apr 2018 16:54:51 +0900</lastBuildDate>
    <docs>http://blogs.law.harvard.edu/tech/rss</docs>
    <generator>Hatena::Blog</generator>
    <items>
    	<item>
          <title>JaSST&#39;18 Tokyoに参加してきました！！</title>
          <link>http://tech.uzabase.com/entry/2018/04/13/165451</link>          
          <description>&lt;p&gt;こんにちは、ユーザベースのPDT(Product Development Team)です。&lt;/p&gt;</description>
          <pubDate>Fri, 13 Apr 2018 16:54:51 +0900</pubDate>
         <guid isPermalink="false">hatenablog://entry/17391345971634758896</guid>
         <enclosure url="https://cdn-ak.f.st-hatena.com/images/fotolife/u/uzabase/20180522/20180522231824.jpg" type="image/jpeg" length="0" />

        </item>
    </items>
</channel>'
````
9. 
````
curl -X POST \
  http://localhost:8080/rssfeed/channel/{feedId}/feeds \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/xml' \
  -H 'Postman-Token: 2250e1d1-4b34-cbc0-474e-ade0ce80fcfd' \
  -d '<item>
                <title>JaSST'\''18 Tokyoに参加してきました！！</title>
                <link>http://tech.uzabase.com/entry/2018/04/13/165451</link>
                <description>&lt;p>こんにちは、ユーザベースのPDT(Product Development Team)です。&lt;/p></description>
                <pubDate>Fri, 13 Apr 2018 16:54:51 +0900</pubDate>
                <guid isPermalink="true">hatenablog://entry/17391345971634758896</guid>
                <enclosure>url="https://cdn.blog.st-hatena.com/images/theme/og-image-1500.png" type="image/png" length="0" </enclosure>
            </item>'
````
10. This is highly flexible now because the APIs can be added for all the operations needed.
