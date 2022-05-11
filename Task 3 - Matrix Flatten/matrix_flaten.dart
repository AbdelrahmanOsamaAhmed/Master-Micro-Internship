import 'dart:io';

//Function to flatten the matrix into 1D list
List matrix_flatten(Iterable<dynamic> list) => [
      for (var item in list)
        if (item is! Iterable) item else ...matrix_flatten(item)
    ];

int index3D_to_index1D(List list3D, var i, var j, var k) {
  var n = list3D.length;
  var m = list3D[0].length;
  var p = list3D[0][0].length;
  if (i >= n || j >= m || k >= p) {
    print("Index out of range");
    return -1;
  }
  return (i * m * p) + (j * p) + k;
}

void main(List<String> args) {
  List lis = [
    [
      [1, 2],
      [3, 4],
      [5, 6]
    ],
    [
      [1, 2],
      [3, 4],
      [5, 6]
    ]
  ];

  print(matrix_flatten(lis));
  print(index3D_to_index1D(lis, 0, 1, 2));
  print(matrix_flatten(lis)[index3D_to_index1D(lis, 0, 1, 2)]);
}
