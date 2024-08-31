# 146. LRU Cache

## Accuracy

- update value means update keys too
- update both times when get, put

## Efficiency

- consider Time Complexity for every method

### 1. Ordered dictionary(LinkedHashMap)

- Get the key / Check if the key exists
	- O(1) by hashmap
- Put the key
	- O(1) by hashmap
- Delete the first added key
	- O(1) by linked list
	
- Time complexity : O(1) both for put and get.
- Space complexity : O(capacity) since the space is used only for a hashmap and double linked list with at most capacity + 1 elements.	

### 2. Hashmap + DoubleLinkedList

- Get the key / Check if the key exists
	- O(1) by hashmap
- Put the key at head
	- O(1) by linked list
- Update the key
	- O(1) by hashmap<linked list>
- Delete the at tail
	- O(1) by linked list

- Time complexity : O(1) both for put and get.
- Space complexity : O(capacity) since the space is used only for a hashmap and double linked list with at most capacity + 1 elements.