Para ejecutar el programa abrir Matlab en este folder y ejecutar las funciones

partirImagen(nombreArchivo, partes):
	Separa las im�genes en tantas diapositivas como indique en la variable partes.
	Utiliza la imagen almacenada en el archio nombreArchivo+".bmp"
	Produce im�genes con las diapositivas usando el nombre nombreArchivo+"-1.bmp", nombreArchivo+"-2.bmp" y as� sucesivamente dependiendo de la cantidad de im�genes a repartir

juntarImagen(nombreArchivo, partes):
	Toma todas las im�genes de la forma nombreArchivo+"-1.bmp", nombreArchivo+"-2.bmp" dependiendo de cu�ntas partes se indique y las une en una sola imagen que queda guardada en el archivo nombreArchivo+"-reunida.bmp"