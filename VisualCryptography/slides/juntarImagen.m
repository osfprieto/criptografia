function juntarImagen(nombreArchivo, partes)
    
    slide = imread(strcat(nombreArchivo, '-', '1', '.bmp'));
    tamanio = size(slide);

    slides = zeros([partes tamanio]);
    for k = 1:partes
        slide = imread(strcat(nombreArchivo, '-', '0'+k, '.bmp'));
        slide = logical(slide);
        slides(k,:,:) = slide(:,:);
    end
    
    %Invertimos para poder sumar normalmente (queremos que 1 sea negro)
    slides = 1-slides;
   
    %juntamos las imágenes
    slides = sum(slides, 1);
    
    %Revertimos para usar los colores bn.
    slides = logical(slides);
    slides = 1-slides;
    
    %Guardamos
    imagenUnida = zeros(tamanio);
    imagenUnida(:,:) = slides(1,:,:);
    imwrite(logical(imagenUnida), strcat(nombreArchivo, '-reunida.bmp'));
end