const fs = require('fs');
const readline = require('node:readline/promises');

// -CONFIGURACION
const archivo = 'books.json';
const rl = readline.createInterface({ input: process.stdin, output: process.stdout });

// -FUNCIONES PARA ARCHIVOS
const cargarLibros = () => {
  // Si no existe devuelve un array vacío
  if (!fs.existsSync(archivo)) return [];
  // Si existe lo lee y lo convierte de JSON a un array de JS.
  return JSON.parse(fs.readFileSync(archivo, 'utf8'));
};

const guardarLibros = (libros) => {
  // Convierte el array de JS a texto JSON Y Guarda
  fs.writeFileSync(archivo, JSON.stringify(libros, null, 2));
};

//  FUNCIÓN PRINCIPAL DEL MENU
async function menu() {
  console.log('\n° Gestor de Libros °');
  console.log('1 - Agregar libro');
  console.log('2 -  Listar libros');
  console.log('3 -  Buscar libro');
  console.log('4 -  Eliminar libro');
  console.log('5 -  Salir');

  while (true) {
    const opcion = await rl.question('\nElige una opción: ');

    // Carga los libros al inicio de cada operación
    let libros = cargarLibros();

    if (opcion === '1') {
      const titulo = await rl.question('Título: ');
      const autor = await rl.question('Autor: ');
      const anio = await rl.question('Año: ');
      libros.push({ titulo, autor, anio });
      guardarLibros(libros);
      console.log('✅ Libro agregado.');
    } 
    else if (opcion === '2') {
      if (libros.length === 0) {
        console.log('No hay libros');
      } else {
        console.log('-Tus Libros-');
        console.table(libros); // console.table() los muestra en una tabla
      }
    } 
    else if (opcion === '3') {
        const busqueda = await rl.question('Título a buscar: ');
        const encontrado = libros.find(l => l.titulo.toLowerCase() === busqueda.toLowerCase());
        if (encontrado) {
            console.log('Libro Encontrado');
            console.log(encontrado);
        } else {
            console.log('No se encontro el libro');
        }
    }
    else if (opcion === '4') {
      const aEliminar = await rl.question('Título a eliminar: ');
      const librosFiltrados = libros.filter(l => l.titulo.toLowerCase() !== aEliminar.toLowerCase());
      if (libros.length === librosFiltrados.length) {
          console.log('Ese libro no existe');
      } else {
          guardarLibros(librosFiltrados);
          console.log('Libro eliminado');
      }
    } 
    else if (opcion === '5') {
      console.log('Adiós! ');
      break; // Rompe el bucle y termina el programa
    } 
    else {
      console.log('Opción no válida.');
    }
  }
  rl.close();
}

// Iniciar el programa
menu();