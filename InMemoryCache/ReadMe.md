Operation	Complexity
put()	O(log N) for expiry queue insertion
get()	O(1) average
remove()	O(1) average
Expiry cleanup	O(log N) per expired task
Cache storage	O(N)
Expiry queue storage	O(M)


-----------------------------------


