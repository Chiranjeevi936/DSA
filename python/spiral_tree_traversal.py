'''
Docstring for spiral_tree_traversal

1. sprial traversal of tree
2. diameter of tree
3. level order traversal
4. graphical print of  tree using rich module
'''


from rich.tree import Tree as rtree
from rich import print
from queue import Queue


class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.key = key

    def __str__(self):
        return str(self.key)


class Tree:

    def __init__(self):
        self.root = None
        self.len = 0
        self.gtree = rtree("This is rich tree")
    
    def __len__(self):
        ''' return number of the nodes in the tree'''
        return self.len
    
    def print_tree_diagram(self):
        ''' level order traversal '''

        from queue import Queue
        q = Queue()
        q.put(self.root)
        while not q.empty():            
            size = q.qsize()
            for _ in range(size):
                temp = q.get()
                print(temp.key, end=' ')
                if temp.left: q.put(temp.left)
                if temp.right: q.put(temp.right)
            print()


    def print_rich_tree(self):
        ''' Print tree node with connected edges '''

        def recur(ghead, node):
            ''' recursively build the graphical nodes '''
            gnode = ghead.add(str(node.key))
            if node.left: recur(gnode, node.left)
            if node.right: recur(gnode, node.right)

        recur(self.gtree, self.root)
        print(str("Rich Graphical Representation Of The Tree").center(100,"="))
        print(self.gtree)

    def print_diameter(self):

        mxd = 0

        def diameter(temp):
            nonlocal mxd
            if temp==None:
                return 0
            lh = diameter(temp.left) if temp.left else 0
            rh = diameter(temp.right) if temp.right else 0
            mxd = max(mxd, lh+rh+1)
            return max(lh, rh)+1

        diameter(self.root)
        print(str("Diameter of the Tree").center(100,'='))
        print(mxd)
    
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
    
    def spiral_print_of_tree(self):
        from queue import LifoQueue
        s1 = LifoQueue()
        s2 = LifoQueue()
        s1.put(self.root)
        while not s1.empty() or not s2.empty():
            
            while not s1.empty():
                temp = s1.get()
                print(temp, end=' ')
                if temp.right: s2.put(temp.right)
                if temp.left: s2.put(temp.left)
            print()

            while not s2.empty():
                temp = s2.get()
                print(temp, end=' ')
                if temp.left: s1.put(temp.left)
                if temp.right: s1.put(temp.right)
            print()



tree = Tree()
tree_list = [10, 22, 33 ,20, 14, 1, 2, 0, 89, 21, 11, 4, 100, 31]
tree_list = [10, 9, 30, 29, 20, 60, 70]
print(tree_list)
for key in tree_list:
    tree.insert_node(key)

print(f"Length: {len(tree)}")
print(str("Level Order Traversal of The Tree").center(100,"-"))
tree.print_tree_diagram()
tree.print_rich_tree()
print(str("Spiral Printing The Tree").center(100, "-"))
tree.spiral_print_of_tree()
tree.print_diameter()