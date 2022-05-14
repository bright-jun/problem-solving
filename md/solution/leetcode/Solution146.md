# 146. LRU Cache

## Accuracy

- update value means update keys too
- update both times when get, put

## Efficiency

- consider Time Complexity for every method
- Get the key / Check if the key exists
	- O(1) by hashmap
- Put the key
	- O(1) by hashmap
- Delete the first added key
	- O(1) by linked list