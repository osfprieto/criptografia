

function partirImagen(nombreArchivo, partes)
    imgOriginal = imread(strcat(nombreArchivo, '.bmp'));
    imgOriginal = logical(imgOriginal);
    tamanio = size(imgOriginal);
    slides = zeros([partes 2*tamanio]);
    
    %Generar ofuscación
    for i = 1:tamanio(1)
        for j = 1:tamanio(2)
            pixelValues = getPixel(imgOriginal(i, j), partes);
            for k = 1:partes
                slides(k, 2*i-1:2*i, 2*j-1:2*j) = pixelValues(:,:,k);
            end
        end
    end
    
    %Guardar archivos
    for k = 1:partes
        slide = zeros(2*tamanio);
        slide(:,:) = slides(k,:,:);
        imwrite(logical(slide), strcat(nombreArchivo, '-', '0'+k, '.bmp'));
    end
end

function pixel = getPixel(valorPixel, partes)
    pixel = zeros(2, 2, partes);
    if (partes == 2)
        
        %White pixel configurations
        whitePixels = zeros([2 2 2 4]);
        
        whitePixels(:,:,1,1) = [1 0; 1 0];
        whitePixels(:,:,2,1) = [1 0; 1 0];
        
        whitePixels(:,:,1,2) = [0 1; 0 1];
        whitePixels(:,:,2,2) = [0 1; 0 1];
        
        whitePixels(:,:,1,3) = [1 0; 0 1];
        whitePixels(:,:,2,3) = [1 0; 0 1];
        
        whitePixels(:,:,1,4) = [0 1; 1 0];
        whitePixels(:,:,2,4) = [0 1; 1 0];
        
        %Black pixel configurations
        blackPixels = zeros([2 2 2 4]);
        
        blackPixels(:,:,1,1) = [1 0; 1 0];
        blackPixels(:,:,2,1) = [0 1; 0 1];
        
        blackPixels(:,:,1,2) = [0 1; 0 1];
        blackPixels(:,:,2,2) = [1 0; 1 0];
        
        blackPixels(:,:,1,3) = [1 0; 0 1];
        blackPixels(:,:,2,3) = [0 1; 1 0];
        
        blackPixels(:,:,1,4) = [0 1; 1 0];
        blackPixels(:,:,2,4) = [1 0; 0 1];
        
        seleccion = randi(randi([1 4]));
        
        if(valorPixel==1) % White
            pixel(:,:,:) = whitePixels(:,:,:,seleccion);  % [[1 1; 1 1] [1 1; 1 1]];
        elseif(valorPixel==0) %Black
            pixel(:,:,:) = blackPixels(:,:,:,seleccion);  % [[0 0; 0 0] [0 0; 0 0]];
        end
    elseif(partes==3)
        
        %White pixel configurations
        whitePixels = zeros([2 2 3 4]);
        
        whitePixels(:,:,1,1) = [1 0; 1 0];
        whitePixels(:,:,2,1) = [1 0; 1 0];
        whitePixels(:,:,3,1) = [1 0; 1 0];
        
        whitePixels(:,:,1,2) = [0 1; 0 1];
        whitePixels(:,:,2,2) = [0 1; 0 1];
        whitePixels(:,:,3,2) = [0 1; 0 1];
        
        whitePixels(:,:,1,3) = [1 0; 0 1];
        whitePixels(:,:,2,3) = [1 0; 0 1];
        whitePixels(:,:,3,3) = [1 0; 0 1];
        
        whitePixels(:,:,1,4) = [0 1; 1 0];
        whitePixels(:,:,2,4) = [0 1; 1 0];
        whitePixels(:,:,3,4) = [0 1; 1 0];
        
        %Black pixel configurations
        blackPixels = zeros([2 2 3 4]);
        
        blackPixels(:,:,1,1) = [1 0; 1 0];
        blackPixels(:,:,2,1) = [0 1; 1 0];
        blackPixels(:,:,3,1) = [1 0; 0 1];
        
        blackPixels(:,:,1,2) = [0 1; 0 1];
        blackPixels(:,:,2,2) = [0 0; 1 1];
        blackPixels(:,:,3,1) = [1 1; 0 0];
        
        blackPixels(:,:,1,3) = [0 1; 0 1];
        blackPixels(:,:,2,3) = [0 1; 0 1];
        blackPixels(:,:,3,1) = [1 0; 1 0];
        
        blackPixels(:,:,1,4) = [1 1; 1 0];
        blackPixels(:,:,2,4) = [1 0; 0 1];
        blackPixels(:,:,3,1) = [0 1; 0 1];
        
        seleccion = randi(randi([1 4]));
        
        if(valorPixel==1) % White
            pixel(:,:,:) = whitePixels(:,:,:,seleccion);  % [[1 1; 1 1] [1 1; 1 1]];
        elseif(valorPixel==0) %Black
            pixel(:,:,:) = blackPixels(:,:,:,seleccion);  % [[0 0; 0 0] [0 0; 0 0]];
        end
    end
end