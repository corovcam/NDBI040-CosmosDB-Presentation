// Connect to the Cosmos DB remote server (if disconnected)
:remote connect tinkerpop.server conf/remote-secure.yaml
:remote console

// 1.
// Find the shortest path between "https://amazon.com/prime" and "https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/7"
// Project the title and url of each node in the path to be returned
g.V().
  has("Node", "url", "https://amazon.com/prime").
  repeat(both().simplePath()).
    until(
      has(
        "url",
        "https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/7")).
  path().by(project('title', 'url').by('title').by('url')).
  limit(1)
// Get the execution profile for the query which shows the execution time
g.V().
  has("Node", "url", "https://amazon.com/prime").
  repeat(both().simplePath()).
    until(
      has(
        "url",
        "https://amazon.com/prime/video/63d895bb-dac9-4d32-8e80-37783fe220c9/season/1/episode/7")).
  path().by(project('title', 'url').by('title').by('url')).
  limit(1).
  executionProfile()

// 2.
// Determine Degree Centrality for each Node in the graph and order by degree value descending
g.V().
  hasLabel("Node").
  project("title", "url", "degree").by("title").by("url").by(bothE().count()).
  order().by(select("degree"), decr)
// Get the execution profile for the query which shows the execution time
g.V().
  hasLabel("Node").
  project("title", "url", "degree").by("title").by("url").by(bothE().count()).
  order().by(select("degree"), decr).
  executionProfile()

// 3.
// Detect the presence of a cycle in the graph (i.e. a loop)
g.V().as("cycle").
  repeat(out().simplePath()).times(2).
  where(out().as("cycle")).
  path().
  dedup().by(unfold().order().by(id).dedup().fold())
// Get the execution profile for the query which shows the execution time
g.V().as("cycle").
  repeat(out().simplePath()).times(2).
  where(out().as("cycle")).
  path().
  dedup().by(unfold().order().by(id).dedup().fold()).
  executionProfile()
