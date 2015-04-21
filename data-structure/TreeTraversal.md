Tree Traversal

Let us consider the below traversals:

Inorder sequence: D B E A F C
Preorder sequence: A B D E C F

In a Preorder sequence, leftmost element is the root of the tree. So we know ‘A’ is root for given sequences. By searching ‘A’ in Inorder sequence, we can find out all elements on left side of ‘A’ are in left subtree and elements on right are in right subtree. So we know below structure now.

                 A
               /   \
             /       \
           D B E     F C
We recursively follow above steps and get the following tree.

                   A
                 /   \
               /       \
              B         C
             / \        /
           /     \    /
          D       E  F



The key is to apply recursion

Example 2:
Inorder sequence: B D C E A F
Preorder sequence: C B D E F A

Step 1: Pre-order left most is C. Look up its position in Inorder Squence.
We get:

                C
              /   \
             /     \
           B D     E A F

Step 2. For the left subtree (temporarily ignore the root node C and right subtree nodes):
Inorder sequence: B D 								ignore (C E A F)
Preorder sequence:  B D								ignore (C E F A)

Leftmost of the preorder sequence is B, therefore, B is the root of left subtree.

                C
              /   \
             /     \
            B 

Now looking at the inorder sequence: (B D),  since D is printed after B, D is the right branch.

                C
              /   \
             /     \
            B 
             \
              \
               D

Step 3. For the right subtree (temporarily ignore the root node C and left subtree nodes):
Inorder sequence: E A F 								ignore (B D C)
Preorder sequence:  E F A								ignore (C B D)

Leftmost of the preorder sequence is E, therefore, E is the root of right subtree.

                C
              /   \
             /     \
                    E

Now looking at the inorder sequence: (E A F),  since A and F are printed after E, A and F are in the right branch.

                C
              /   \
             /     \
                    E
                     \
                      \
                     A  F

Again since E has been determined as the root. We can further simply the sequences to the information that we need.
Inorder sequence: A F 								
Preorder sequence:  F A								

Leftmost of the preorder sequence is F, therefore, F is the root of right subtree (of the subtree rooted at E).
                
                C
              /   \
             /     \
                    E
                     \
                      \
                       F

Since in the inorder sequence: A F, A appears in front F. Therefore, A is the left node.

                C
              /   \
             /     \
                    E
                     \
                      \
                       F
                      /
                     /
                    A 