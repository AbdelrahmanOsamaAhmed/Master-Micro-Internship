import 'dart:io';

List matrix_flatten(Iterable<dynamic> list) => [
      for (var item in list)
        if (item is! Iterable) item else ...matrix_flatten(item)
    ];


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
}
