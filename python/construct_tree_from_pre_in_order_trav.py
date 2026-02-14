'''
Docstring for construct_tree_from_pre_in_order_trav
'''


class node:

    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
    
    def __str__(self):
        return f"{ self.left.key if self.left else self.left } <- ({self.key}) -> {self.right.key if self.right else self.right}"
        
    


p = [10, 20, 30, 40 ,50]
i = [20, 10, 40, 30 , 50]

pre_index = 0
def construct_tree(si, ei):
    print(si, ei)
    global pre_index
    if si > ei: return None
    print("pre_index: ",pre_index)
    r = node(p[pre_index])
    print("p[pre_index]: ", p[pre_index])
    ri = i.index(p[pre_index])
    print("ri: ", ri)

    pre_index+=1

    r.left = construct_tree(si, ri - 1)
    r.right = construct_tree(ri+1, ei)
    return r


r = construct_tree(0, len(i)-1)

def print_tree(r):

    if r == None: print(None)


