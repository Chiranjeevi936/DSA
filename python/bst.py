'''
Docstring for bst

1. Binary serach Tree crub ops
    - insertion
    - search
    - deletion
'''




from rich.tree import Tree as rtree
from rich import print
from queue import Queue
from random import randrange


class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.key = key

    def  __hash__(self):
        return int(self.key)

    def __repr__(self):
        return str(self.key)

    def __eq__(self, other):
        if isinstance(other, Node):
            return self.key == other.key
        if isinstance(other, int):
            return self.key == other
        return False
    
    def __lt__(self, other):
        if isinstance(other, Node):
            return self.key < other.key
        if isinstance(other, int):
            return self.key < other
        return False
        
    
    def __gt__(self, other):
        if isinstance(other, Node):
            return self.key > other.key
        if isinstance(other, int):
            return self.key > other
        return False


class BST:

    def __init__(self):
        self.root = None
        self.len = 0

    def __len__(self):
        ''' return number of the nodes in the tree'''
        print(str(f"Length Of The Tree").center(100, "*"))
        print(self.len)
        return self.len

    def print_rich_tree(self, tree_head=None):
        ''' Print tree node with connected edges '''

        def recur(ghead, node):
            ''' recursively build the graphical nodes '''
            gnode = ghead.add(str(node.key))
            if node.left: recur(gnode, node.left)
            if node.right: recur(gnode, node.right)
        tree_head = self.root if tree_head == None else tree_head
        self.gtree = rtree("This is rich tree")
        recur(self.gtree, tree_head)
        print(str("Rich Graphical Representation Of The Tree").center(100,"*"))
        print(self.gtree)

    def insert_node(self, key):
        ''' Insert one node at a time to the tree iteratively '''
        new_node = Node(key)
        if self.root == None:
            self.root = new_node
            self.len +=1
        else:
            temp = self.root
            while True:
                if new_node.key < temp.key:
                    if temp.left == None:
                        temp.left = new_node
                        self.len +=1
                        break
                    else:
                        temp = temp.left
                if new_node.key > temp.key:
                    if temp.right == None:
                        temp.right = new_node
                        self.len +=1
                        break
                    else:
                        temp = temp.right

    def search_node(self, key):

        def search(curr_node):
            nonlocal key
            if curr_node == None:
                return None
            if curr_node == key:
                return curr_node
            lf = search(curr_node.left)
            rf = search(curr_node.right)
            return lf if lf else rf

        return search(self.root)

    def get_inorder_successor(self, target):

        def recur(node):
            if node == None:
                return None
            while node.left != None:
                node = node.left
            return node
        print(str(f"Inorder Successer Of {target} Is").center(100, "*"))
        successor = recur(target.right)
        print(successor)
        return successor


    def delete_one_element(self, key):

        def delete(curr_node, key):
            print(f"curr_node: {curr_node}")
            if curr_node == None:
                return None
            if key > curr_node:
                curr_node.right = delete(curr_node.right, key)
            elif key < curr_node:
                curr_node.left = delete(curr_node.left, key)
            else:
                print(f"Deleting node: {curr_node}")
                if curr_node.left == None:
                    return curr_node.right
                elif curr_node.right == None:
                    return curr_node.left
                else:
                    succersor = self.get_inorder_successor(curr_node)
                    print(f"succersor of {curr_node}: {succersor}")
                    curr_node.key = succersor.key
                    curr_node.right = delete(curr_node.right, succersor.key)
            return curr_node

        print(str(f"Deleting {key}").center(100, "*")) 
        print(delete(self.root, key))
        self.print_rich_tree()

bst = BST()
keys = [randrange(20,  1000, step=20) for _ in range(10)]
print(keys)
keys = [876, 732, 254, 784, 376, 757, 916, 371, 422, 934]
# print(keys)
for k in keys:
    bst.insert_node(k)

len(bst)
bst.print_rich_tree()
# print( bst.search_node(732) )
# bst.get_inorder_successor(bst.search_node(376))
bst.delete_one_element(732)
