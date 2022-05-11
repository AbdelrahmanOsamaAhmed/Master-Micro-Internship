#Function to flatten the matrix into 1D list
def flatten(l):
    return [
            x 
            for item in l
            for c in item
            for x in c
        ]
    

#Function to convert the i,j,k index into 1D list index
def index3D_to_index1D (list3D , i , j , k) :
    n = len(list3D)
    m = len(list3D[0])
    p = len(list3D[0][0])
    if (i >= n or j >= m or k >= p) :
        print("Index out of range")
        return -1
    return (i*m*p)+(j*p)+k

#Verfication
lis = [
    [[1,2],[3,4],[5,6]],
    [[1,2],[3,4],[5,6]]
]

list1D = flatten(lis)
print (lis[1][2][0])
print(list1D[index3D_to_index1D(lis,1,2,0)])