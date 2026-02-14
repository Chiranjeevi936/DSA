'''
Docstring for spiral_tree_traversal

1. sprial traversal of tree
2. diameter of tree
3. level order traversal
4. graphical print of  tree using rich module
5. lowest common ancestor of a tree
4. burn a binary tree from a leaf node

'''


from rich.tree import Tree as rtree
from rich import print
from queue import Queue


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


    def print_rich_tree(self, tree_head=None):
        ''' Print tree node with connected edges '''

        def recur(ghead, node):
            ''' recursively build the graphical nodes '''
            gnode = ghead.add(str(node.key))
            if node.left: recur(gnode, node.left)
            if node.right: recur(gnode, node.right)
        tree_head = self.root if tree_head == None else tree_head
        recur(self.gtree, tree_head)
        print(str("Rich Graphical Representation Of The Tree").center(100,"*"))
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
        print(str("Diameter of the Tree").center(100,'-'))
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

    def lca(self, n1 , n2):

        def do(node):
            nonlocal n1, n2
            if  node==None:
                return None

            if n1 == node or n2 == node:
                return node

            left = do(node.left)
            right = do(node.right)

            if left and right:
                return node

            return left if left else right

        print(str(f"Lowest Common Ancestor of Two Node {n1} and {n2}").center(100, "*"))
        print(do(self.root))

    def burn_tree(self, target):
        parents = {}
        start =None

        def find_parents(node):
            nonlocal parents, target , start
            if node == None: return
            if node == target:
                start = node
            if node.left:
                parents[node.left] = node
                find_parents(node.left)
            if node.right:
                parents[node.right] = node
                find_parents(node.right)

        print(f"start: {start}")
        if start == None:
            print("Halting The Burning Of The Tree, Cause Target Leaf Node Not Found!!")
            return
        find_parents(self.root)
        parents[self.root] = None
        print(parents)
        q = Queue(maxsize=self.len)
        q.put(start)
        time = 0
        visited = set([start])
        while not q.empty():
            visited_new = False
            node = q.get()
            for  i in (node.left, node.right , parents[node]):
                if i and i not in visited:
                    visited.add(i)
                    q.put(i)
                    visited_new = True
            if visited_new:
                time+=1

        print(time)


    def print_serilized_deserilized_array(self):

        serilized_array = []

        def serilize(node):
            nonlocal serilized_array
            if node == None:
                serilized_array.append(-1)
            else:
                serilized_array.append(node)

                serilize(node.left)
                serilize(node.right)

        serilize(self.root)
        print(str("Serilized Tree Data").center(100, '*'))
        print(serilized_array)

        # root = Node( serilized_array[0] )
        tracker = 0
        def deserilize():
            nonlocal tracker
            if tracker == len(serilized_array):
                return None
            key = serilized_array[tracker]
            tracker +=1

            if key == -1:
                return None
            root = Node(key)
            root.left = deserilize()
            root.right = deserilize()
            return root

        root = deserilize()


        self.print_rich_tree(root)







tree = Tree()
tree_list = [10, 22, 33 ,20, 14, 1, 2, 0, 89, 21, 11, 4, 100, 31]
# tree_list = [10, 9, 30, 29, 20, 60, 70]
tree_list = [55, 35, 25, 40, 50, 75, 85]

print(tree_list)
for key in tree_list:
    tree.insert_node(key)

print(f"Length: {len(tree)}")
print(str("Level Order Traversal of The Tree").center(100,"-"))
# tree.print_tree_diagram()
tree.print_rich_tree()
# print(str("Spiral Printing The Tree").center(100, "-"))
# tree.spiral_print_of_tree()
# tree.print_diameter()
# tree.lca(11, 100)
tree.burn_tree(25)

tree.print_serilized_deserilized_array()