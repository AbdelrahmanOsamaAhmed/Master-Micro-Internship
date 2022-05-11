def flatten(l):
    """
    flat=[]
    for item in l:
        for c in item:
            for x in c:
                flat.append(x);
    return flat
    """

    return [x 
            for item in l
            for c in item
            for x in c
            ]
    



lis = [
    [[1,2],[3,4],[5,6]],
    [[1,2],[3,4],[5,6]]
]

print(flatten(lis))