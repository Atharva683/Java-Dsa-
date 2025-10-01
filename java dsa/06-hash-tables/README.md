# Hash Tables - Fast Key-Value Storage

## Why Hash Tables Are Essential
Hash tables (HashMap in Java) provide average O(1) time complexity for:
- Insertion, deletion, and lookup operations
- Solving many optimization problems
- Caching and memoization
- Frequency counting and duplicate detection

## What You'll Learn
1. **Hash Function Concepts**: How hashing works
2. **Collision Handling**: Chaining and open addressing  
3. **HashMap Usage**: Java's built-in implementation
4. **HashSet Usage**: For unique elements
5. **Common Patterns**: Frequency maps, two-sum variants
6. **LeetCode Problems**: Hash table interview questions

## Key Applications
- **Two Sum Problem**: O(n) solution using hash map
- **Frequency Counting**: Count occurrences of elements
- **Caching**: Store computed results for reuse
- **Database Indexing**: Fast data retrieval
- **Set Operations**: Union, intersection, difference

## Time Complexity
- **Average Case**: Insert O(1), Delete O(1), Search O(1)
- **Worst Case**: Insert O(n), Delete O(n), Search O(n)
- **Space Complexity**: O(n) where n is number of elements

## Hash Function Requirements
1. **Deterministic**: Same input always produces same output
2. **Uniform Distribution**: Spreads keys evenly across buckets
3. **Fast Computation**: Should be quick to calculate
4. **Minimize Collisions**: Different keys should hash to different values

Ready to master fast lookups? 🔍