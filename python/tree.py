
'''
1. contains logic for pre,in,post orders of traversal
2. level order traversal
3. width of the tree
4. k-distance nodes
5. tree to dll convertion
'''


from typing import Union
from rich.tree import Tree as rtree
from rich import print
from queue import Queue
from random import randint


class emptyListException(Exception):
    '''
    Custom Exception to raise when list is empty
    '''
    def __init__(self, message):
        super().__init__(message)

class dll:
    class node:
        def __init__(self, key):
            self.prev = None
            self.next = None
            self.key = key
        
        def __str__(self):
            l = [
                    f"Key: {self.key}",
                    f"prev: { self.prev.key if self.prev else self.prev }",
                    f"next: {self.next.key if self.next else self.next}"
            ]
            return ', '.join(l)

    def __init__(self):
        self.head = None
        self.tail = None
        self.length = None

    def _print(self, order='f'):
        '''
        print the order
        order: specify the order of traversal(f -> forware, r/1/reverse -> reverse)
        '''
        reverse = True if order in ['r', 'reverse', 1] else False
        if not self.head:
            print("empty dll...")
        else:
            curr = self.tail if reverse else self.head
            while curr:
                print(f"{'<-' if curr.prev else ''} {curr.key} {'->' if curr.next else ''}", end=' ')
                curr = curr.prev if reverse else curr.next
        print()

    def insert_node(self, key):
        '''
        insert a node to the linked list
        :param key(int): value to add a node with
        '''
        new_node = dll.node(key)
        if not self.head:
            self.head = new_node
            self.tail = new_node
        else:
            curr = self.head
            while curr.next:
                curr = curr.next
            curr.next = new_node
            new_node.prev = curr
            self.tail = new_node

    def insert_multiple_nodes(self, keys=[]):
        if not isinstance(keys, list):
            raise ValueError(f'Provide List of keys not {type(keys)}')
        if not len(keys):
            raise emptyListException("please provide list with atleast one element")

        for i in keys:
            self.insert_node(i)


class node:

    def __init__(self, data: Union[str,int,None] = None):
        self.left = None
        self.right = None
        self.key = data
        self.gtree = rtree(f"Tree diagram of {self.key}")

    def insert_element(self, key):        
        if self.key is None:
            self.key = key
            self.gtree = rtree(f"Tree diagram of {self.key}")
        else:
            temp = self
            while True:
                if int(key) < int(temp.key) :
                    if temp.left:
                        temp = temp.left 
                    else:
                        temp.left = node(key)
                        break
                elif int(key) == int(temp.key):
                    break
                else:
                    if temp.right:
                        temp = temp.right
                    else:
                        temp.right = node(key)
                        break


    def get_size_of_tree(self):
        ls = self.left.get_size_of_tree() if self.left else 0
        rs = self.right.get_size_of_tree() if self.right else 0
        return 1 + ls + rs        

    def contruct_tree_diagram(self,ghead,head):
        gnode = ghead.add(str(head.key))
        if head.left: self.contruct_tree_diagram(gnode, head.left)
        if head.right: self.contruct_tree_diagram(gnode, head.right)

    def print_tree_diagram(self):
        self.contruct_tree_diagram(self.gtree,self)
        print(self.gtree)

    def print_level_order_traversal(self):
        q = Queue()
        q.put(self)
        l = list()
        while q.empty() == False:
            cnode = q.get()
            l.append(cnode.key)
            if cnode.left: q.put(cnode.left)
            if cnode.right: q.put(cnode.right)
        return l
    
    def print_nodes_at_k_distance(self, k, l:list=[]):
        if k==0:
            l.append(self.key)
            return l
        if self.left: l = self.left.print_nodes_at_k_distance(k-1) 
        if self.right: r = self.right.print_nodes_at_k_distance(k-1)
        return l

    def height(self):
        lh = self.left.height() if self.left else 0
        rh = self.right.height() if self.right else 0
        return 1 + max(lh, rh)

    def width_of_the_tree(self):
        q =  Queue()
        width = 1
        q.put(self)
        while not q.empty():
            level_size = q.qsize()
            width = max(level_size, width)
            for _ in range(level_size):
                temp_node = q.get()
                s = f"({temp_node.key})"
                print(f"{s:^5}",end=' ')
                if temp_node.left: q.put(temp_node.left)
                if temp_node.right: q.put(temp_node.right)
            print()
        return width

    def inorder_print(self,l:list = []):        
        if self.left: l = self.left.inorder_print(l)
        l.append(self.key)
        if self.right: l = self.right.inorder_print(l)
        return l
    
    def postorder_print(self, l:list=[]):
        if self.left: l = self.left.postorder_print(l)
        if self.right: l = self.right.postorder_print(l)
        l.append(self.key)
        return l

    def preorder_print(self, l:list=[]):
        l.append(self.key)
        if self.left: l = self.left.preorder_print(l)
        if self.right: l = self.right.preorder_print(l)
        return l
    
    def convert_binary_to_dll(self):
        '''
        Docstring for convert_binary_to_dll
        '''
        prev = None
        def convert(root):
            nonlocal prev
            if root == None: return root
            head = convert(root.left)
            if prev == None: 
                head = root            
            else:
                root.left = prev
                prev.right = root
            prev = root
            convert(root.right)
            return head
        
        head = convert(self)
        print("self: ", self)
        print("head: ", head)
        curr = head

        while curr:
            print(curr)
            curr = curr.right


        
         





    
    def __str__(self):
        l = [
                f"Key: {self.key}",
                f"left: { self.left.key if self.left else self.left }",
                f"right: {self.right.key if self.right else self.right}"
        ]
        return ', '.join(l)
    

l = [ 10, 3, 2, 1, 5, 20, 15, 25 ]

root = node()
for key in l: root.insert_element(key)
root.print_tree_diagram()
print("Level Order Traversal: ",root.print_level_order_traversal())
print("size of the tree: ", root.get_size_of_tree() )
width = root.width_of_the_tree()
print("max width of the tree: ", width)
print("converting to dll: ")
root.convert_binary_to_dll()

# d = dll()
# # for i in l: d.insert_node(i)
# d.insert_multiple_nodes([1, 3, 4])
# d._print()



