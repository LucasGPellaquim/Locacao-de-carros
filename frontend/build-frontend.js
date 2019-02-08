
var path_origem = 'dist';
var path_destino = '../backend/src/main/resources/static';

var fs = require('fs');
var path = require('path');

var copyRecursiveSync = function(src, dest) {

  var exists = fs.existsSync(src);
  var stats = exists && fs.statSync(src);
  var isDirectory = exists && stats.isDirectory();

  if (exists && isDirectory) {

    fs.mkdirSync(dest);

    fs.readdirSync(src).forEach(
        function(childItemName) {
          copyRecursiveSync(
            path.join(src, childItemName),
            path.join(dest, childItemName)
          );
    });
  } else {
    fs.linkSync(src, dest);
  }
};

var deleteFolderRecursive = function(path) {

  if (fs.existsSync(path)) {

    fs.readdirSync(path).forEach(function(file, index){

      var curPath = path + "/" + file;

      if (fs.lstatSync(curPath).isDirectory()) { // recurse
        deleteFolderRecursive(curPath);
      } else { // delete file
        fs.unlinkSync(curPath);
      }

    });
    fs.rmdirSync(path);
  }
};

deleteFolderRecursive(path_destino);
copyRecursiveSync(path_origem, path_destino);
