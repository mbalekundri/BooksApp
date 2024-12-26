# Spring boot Redis implementation
# https://www.geeksforgeeks.org/spring-boot-caching-with-redis/
# https://javatechonline.com/how-to-implement-redis-cache-in-spring-boot-application/

## How to use commands in Redis CLI?
1) To get all Keys: 127.0.0.1:6379> KEYS *
2) To set simple string key value pair: 127.0.0.1:6379>SET mykey “Hello\nWorld”
3) To get value : 127.0.0.1:6379>GET mykey
4) To remove all the keys of all the existing database:  127.0.0.1:6379> FLUSHALL
5) To delete all the keys of the DB # 4:  127.0.0.1:6379> -n 4 FLUSHDB

## Best Practices for Redis Caching in Spring Boot
1) Choose Appropriate Cache Keys: Use unique and meaningful keys to avoid cache collisions and ensure accurate cache retrieval.
2) Set Expiry Times: Configure expiration times to prevent stale data and manage memory usage effectively.
3) Monitor Cache Performance: Regularly monitor Redis performance and adjust configurations based on usage patterns to maintain optimal performance.
4) Evict Cache When Necessary: Use the @CacheEvict annotation to clear stale or invalid data from the cache to maintain consistency.
5) Use an Appropriate Caching Strategy: Choose the right caching strategy (e.g., read-through, write-through, write-behind) based on the specific needs of your application.

# Terraform with AWS
1) Terraform is an open-source infrastructure as code software tool created by HashiCorp. It enables users to define and provision data center infrastructure using a declarative configuration language known as HashiCorp Configuration Language (HCL), or optionally JSON.
2) Terraform manages external resources like public cloud infrastructure, private cloud infrastructure, network appliances, software as a service, and platform as a service with a concept known as providers.
3) Terraform is a tool for building, changing, and versioning infrastructure safely and efficiently. Terraform can manage existing and popular service providers as well as custom in-house solutions.
4) https://www.youtube.com/watch?v=IyfdN5_fB1I&list=PLOa-edppsqFm10V0vh-szO7YffAKcW5K-