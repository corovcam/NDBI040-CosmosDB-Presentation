// Connect to the Cosmos DB remote server (if disconnected)
:remote connect tinkerpop.server conf/remote-secure.yaml
:remote console

g.V().drop()
g.E().drop()

// Partition Key = recordId

// create website records
g.addV('WebsiteRecord').property('recordId', 1).property('url', 'https://example.com').property('boundaryRegexp', 'example').property('periodicity', 60).property('title', 'Example Website').property('isActive', true).property('isBeingCrawled', false).as('w1')
g.addV('WebsiteRecord').property('recordId', 2).property('url', 'https://google.com').property('boundaryRegexp', 'google').property('periodicity', 120).property('title', 'Google').property('isActive', true).property('isBeingCrawled', false).as('w2')
g.addV('WebsiteRecord').property('recordId', 3).property('url', 'https://amazon.com').property('boundaryRegexp', 'amazon').property('periodicity', 180).property('title', 'Amazon').property('isActive', true).property('isBeingCrawled', true).as('w3')

// create executions
g.addV('Execution').property('recordId', 1).property('executionId', 1).property('isCompleted', true).property('startTime', '2023-04-27T15:30:00').property('endTime', '2023-04-27T16:30:00').property('sitesCrawledCount', 2).as('e1')
g.addV('Execution').property('recordId', 2).property('executionId', 2).property('isCompleted', true).property('startTime', '2023-04-28T08:00:00').property('endTime', '2023-04-28T09:00:00').property('sitesCrawledCount', 3).as('e2')
g.addV('Execution').property('recordId', 3).property('executionId', 3).property('isCompleted', false).property('startTime', '2023-04-29T10:00:00').property('endTime', '').property('sitesCrawledCount', 0).as('e3')

// create nodes + add respective recordId to nodes
g.addV('Node').property('recordId', 1).property('url', 'https://example.com').property('executionId', 1).property('title', 'Example Website').property('crawlTime', 30).property('data', '').as('n1')
g.addV('Node').property('recordId', 1).property('url', 'https://example.com/about').property('executionId', 1).property('title', 'About Us').property('crawlTime', 45).property('data', '').as('n2')
g.addV('Node').property('recordId', 2).property('url', 'https://google.com').property('executionId', 2).property('title', 'Google').property('crawlTime', 60).property('data', '').as('n3')
g.addV('Node').property('recordId', 2).property('url', 'https://google.com/search').property('executionId', 2).property('title', 'Google Search').property('crawlTime', 70).property('data', '').as('n4')
g.addV('Node').property('recordId', 2).property('url', 'https://amazon.com').property('executionId', 2).property('title', 'Amazon').property('crawlTime', 80).property('data', '').as('n5')

g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com').property('executionId', 3).property('title', 'Amazon').property('crawlTime', 80).property('data', '').as('n6')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/search').property('executionId', 3).property('title', 'Amazon Search').property('crawlTime', 80).property('data', '').as('n7')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/checkout').property('executionId', 3).property('title', 'Amazon Checkout').property('crawlTime', 80).property('data', '').as('n8')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/cart').property('executionId', 3).property('title', 'Amazon Cart').property('crawlTime', 80).property('data', '').as('n9')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime').property('executionId', 3).property('title', 'Amazon Prime').property('crawlTime', 80).property('data', '').as('n10')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video').property('executionId', 3).property('title', 'Amazon Prime Video').property('crawlTime', 80).property('data', '').as('n11')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/music').property('executionId', 3).property('title', 'Amazon Prime Music').property('crawlTime', 80).property('data', '').as('n12')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/photos').property('executionId', 3).property('title', 'Amazon Prime Photos').property('crawlTime', 80).property('data', '').as('n13')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/reading').property('executionId', 3).property('title', 'Amazon Prime Reading').property('crawlTime', 80).property('data', '').as('n14')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/pantry').property('executionId', 3).property('title', 'Amazon Prime Pantry').property('crawlTime', 80).property('data', '').as('n15')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/wardrobe').property('executionId', 3).property('title', 'Amazon Prime Wardrobe').property('crawlTime', 80).property('data', '').as('n16')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/now').property('executionId', 3).property('title', 'Amazon Prime Now').property('crawlTime', 80).property('data', '').as('n17')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/air').property('executionId', 3).property('title', 'Amazon Prime Air').property('crawlTime', 80).property('data', '').as('n18')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9').property('executionId', 3).property('title', 'Penguins of Madagascar').property('crawlTime', 80).property('data', '').as('n19')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 1').property('crawlTime', 80).property('data', '').as('n20')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/1').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 1 - Episode 1').property('crawlTime', 80).property('data', '').as('n21')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/2').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 1 - Episode 2').property('crawlTime', 80).property('data', '').as('n22')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/3').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 1 - Episode 3').property('crawlTime', 80).property('data', '').as('n23')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/4').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 1 - Episode 4').property('crawlTime', 80).property('data', '').as('n24')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/5').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 1 - Episode 5').property('crawlTime', 80).property('data', '').as('n25')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/6').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 1 - Episode 6').property('crawlTime', 80).property('data', '').as('n26')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/7').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 1 - Episode 7').property('crawlTime', 80).property('data', '').as('n27')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 2').property('crawlTime', 80).property('data', '').as('n28')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2/episode/1').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 2 - Episode 1').property('crawlTime', 80).property('data', '').as('n29')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2/episode/2').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 2 - Episode 2').property('crawlTime', 80).property('data', '').as('n30')
g.addV('Node').property('recordId', 3).property('url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2/episode/3').property('executionId', 3).property('title', 'Penguins of Madagascar - Season 2 - Episode 3').property('crawlTime', 80).property('data', '').as('n31')

// create tags
g.addV('Tag').property(list, 'recordId', 1).property('name', 'technology').property('description', 'Technology related content').as('t1')
g.addV('Tag').property(list, 'recordId', 2).property('name', 'news').property('description', 'News related content').as('t2')
g.addV('Tag').property(list, 'recordId', 2).property('name', 'sports').property('description', 'Sports related content').as('t3')


// create relationships
g.V().has('WebsiteRecord', 'recordId', 1).as('w1').V().has('Execution', 'executionId', 1).as('e1').addE('STARTED').from('w1').to('e1')
g.V().has('WebsiteRecord', 'recordId', 2).as('w2').V().has('Execution', 'executionId', 2).as('e2').addE('STARTED').from('w2').to('e2')
g.V().has('WebsiteRecord', 'recordId', 3).as('w3').V().has('Execution', 'executionId', 3).as('e3').addE('STARTED').from('w3').to('e3')
g.V().has('WebsiteRecord', 'recordId', 1).as('w1').V().has('Tag', 'recordId', 1).as('t1').addE('HAS_TAG').from('w1').to('t1')
g.V().has('WebsiteRecord', 'recordId', 2).as('w2').V().has('Tag', 'recordId', 2).as('t2').addE('HAS_TAG').from('w2').to('t2')
g.V().has('WebsiteRecord', 'recordId', 2).as('w2').V().has('Tag', 'recordId', 3).as('t3').addE('HAS_TAG').from('w2').to('t3')
g.V().has('Execution', 'executionId', 1).as('e1').V().has('Node', 'url', 'https://example.com').has('executionId', 1).as('n1').addE('HAS_ROOT').from('e1').to('n1')
g.V().has('Execution', 'executionId', 2).as('e2').V().has('Node', 'url', 'https://google.com').has('executionId', 2).as('n3').addE('HAS_ROOT').from('e2').to('n3')
g.V().has('Execution', 'executionId', 3).as('e3').V().has('Node', 'url', 'https://amazon.com').has('executionId', 3).as('n8').addE('HAS_ROOT').from('e3').to('n8')

// Add relationships nodes to nodes for execution 1
g.V().has('Node', 'url', 'https://example.com').has('executionId', 1).as('n1').V().has('Node', 'url', 'https://example.com/about').has('executionId', 1).as('n2').addE('LINKS_TO').from('n1').to('n2')
g.V().has('Node', 'url', 'https://example.com/about').has('executionId', 1).as('n2').V().has('Node', 'url', 'https://example.com').has('executionId', 1).as('n1').addE('LINKS_TO').from('n2').to('n1')

// Add relationships nodes to nodes for execution 2
g.V().has('Node', 'url', 'https://google.com').has('executionId', 2).as('n3').V().has('Node', 'url', 'https://google.com/search').has('executionId', 2).as('n4').addE('LINKS_TO').from('n3').to('n4')
g.V().has('Node', 'url', 'https://google.com/search').has('executionId', 2).as('n4').V().has('Node', 'url', 'https://google.com').has('executionId', 2).as('n3').addE('LINKS_TO').from('n4').to('n3')
g.V().has('Node', 'url', 'https://google.com/search').has('executionId', 2).as('n4').V().has('Node', 'url', 'https://amazon.com').has('executionId', 2).as('n5').addE('LINKS_TO').from('n4').to('n5')
g.V().has('Node', 'url', 'https://amazon.com').has('executionId', 2).as('n5').V().has('Node', 'url', 'https://google.com/search').has('executionId', 2).as('n4').addE('LINKS_TO').from('n5').to('n4')

// Add relationships nodes to nodes for execution 3
// Some sample hierachy for amazon.com
g.V().has('Node', 'url', 'https://amazon.com').has('executionId', 3).as('n8').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n8').to('n9')
g.V().has('Node', 'url', 'https://amazon.com').has('executionId', 3).as('n8').V().has('Node', 'url', 'https://amazon.com/search').has('executionId', 3).as('n7').addE('LINKS_TO').from('n8').to('n7')
g.V().has('Node', 'url', 'https://amazon.com').has('executionId', 3).as('n8').V().has('Node', 'url', 'https://amazon.com/checkout').has('executionId', 3).as('n10').addE('LINKS_TO').from('n8').to('n10')
g.V().has('Node', 'url', 'https://amazon.com').has('executionId', 3).as('n8').V().has('Node', 'url', 'https://amazon.com/cart').has('executionId', 3).as('n11').addE('LINKS_TO').from('n8').to('n11')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com').has('executionId', 3).as('n8').addE('LINKS_TO').from('n9').to('n8')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/video').has('executionId', 3).as('n10').addE('LINKS_TO').from('n9').to('n10')
g.V().has('Node', 'url', 'https://amazon.com/prime/video').has('executionId', 3).as('n10').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n10').to('n9')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/now').has('executionId', 3).as('n11').addE('LINKS_TO').from('n9').to('n11')
g.V().has('Node', 'url', 'https://amazon.com/prime/now').has('executionId', 3).as('n11').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n11').to('n9')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/music').has('executionId', 3).as('n12').addE('LINKS_TO').from('n9').to('n12')
g.V().has('Node', 'url', 'https://amazon.com/prime/music').has('executionId', 3).as('n12').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n12').to('n9')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/reading').has('executionId', 3).as('n13').addE('LINKS_TO').from('n9').to('n13')
g.V().has('Node', 'url', 'https://amazon.com/prime/reading').has('executionId', 3).as('n13').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n13').to('n9')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/photos').has('executionId', 3).as('n14').addE('LINKS_TO').from('n9').to('n14')
g.V().has('Node', 'url', 'https://amazon.com/prime/photos').has('executionId', 3).as('n14').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n14').to('n9')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/pantry').has('executionId', 3).as('n15').addE('LINKS_TO').from('n9').to('n15')
g.V().has('Node', 'url', 'https://amazon.com/prime/pantry').has('executionId', 3).as('n15').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n15').to('n9')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/wardrobe').has('executionId', 3).as('n16').addE('LINKS_TO').from('n9').to('n16')
g.V().has('Node', 'url', 'https://amazon.com/prime/wardrobe').has('executionId', 3).as('n16').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n16').to('n9')
g.V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/air').has('executionId', 3).as('n17').addE('LINKS_TO').from('n9').to('n17')
g.V().has('Node', 'url', 'https://amazon.com/prime/air').has('executionId', 3).as('n17').V().has('Node', 'url', 'https://amazon.com/prime').has('executionId', 3).as('n9').addE('LINKS_TO').from('n17').to('n9')

// Some example resource links, including taxonomy for video content
g.V().has('Node', 'url', 'https://amazon.com/prime/video').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9').has('executionId', 3).as('n19').addE('LINKS_TO').from('n9').to('n19')

// Sample taxonomy for video content for a specific season and episode
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9').has('executionId', 3).as('n19').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').addE('LINKS_TO').from('n19').to('n20')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/1').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/2').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/3').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/4').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/5').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/6').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/7').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2').has('executionId', 3).as('n29').addE('LINKS_TO').from('n9').to('n29')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/7').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2/episode/1').has('executionId', 3).as('n29').addE('LINKS_TO').from('n9').to('n29')

g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9').has('executionId', 3).as('n19').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2').has('executionId', 3).as('n20').addE('LINKS_TO').from('n19').to('n20')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2/episode/1').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2/episode/2').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2').has('executionId', 3).as('n20').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2/episode/3').has('executionId', 3).as('n21').addE('LINKS_TO').from('n20').to('n21')

// Some additional links to make the graph more interesting
g.V().has('Node', 'url', 'https://amazon.com/prime/video').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2').has('executionId', 3).as('n28').addE('LINKS_TO').from('n9').to('n28')
g.V().has('Node', 'url', 'https://amazon.com/prime/video').has('executionId', 3).as('n9').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n20').addE('LINKS_TO').from('n9').to('n20')
// Artificially generate a cycle in the graph (Webcrawler will detect cycles and not traverse them twice)
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1').has('executionId', 3).as('n19').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9').has('executionId', 3).as('n20').addE('LINKS_TO').from('n19').to('n20')
g.V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/2').has('executionId', 3).as('n19').V().has('Node', 'url', 'https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9').has('executionId', 3).as('n20').addE('LINKS_TO').from('n19').to('n20')

