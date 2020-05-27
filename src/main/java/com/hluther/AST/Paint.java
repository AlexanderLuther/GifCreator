package com.hluther.AST;

import com.hluther.entityClasses.CColor;
import com.hluther.entityClasses.Canvas;
import com.hluther.entityClasses.ImageDTO;
/**
 *
 * @author helmuth
 */
public class Paint implements Instruction {

    private Operation idColor;
    private Operation idImage;
    private Operation posX;
    private Operation posY;
    private Operation startIndexX;
    private Operation endIndexX;
    private Operation startIndexY;
    private Operation endIndexY;
    private int type;
    
    public Paint(Operation idColor, Operation idImage, Operation posX, Operation posY, int type) {
        this.idColor = idColor;
        this.idImage = idImage;
        this.posX = posX;
        this.posY = posY;
        this.type = type;
    }
    
    public Paint(Operation idColor, Operation idImage, Operation startIndex, Operation endIndex, Operation pos, int type) {
        this.idColor = idColor;
        this.idImage = idImage;
        
        if(type == 1){
            this.startIndexX = startIndex;
            this.endIndexX = endIndex;
            this.posY = pos;
            this.type = 1;
        }
        else if(type == 2){
            this.startIndexY = startIndex;
            this.endIndexY = endIndex;
            this.posX = pos;
            this.type = 2;
        
        }
    }
    
    public Paint(Operation idColor, Operation idImage, Operation startIndexX, Operation endIndexX, Operation startIndexY, Operation endIndexY, int type) {
        this.idColor = idColor;
        this.idImage = idImage;
        this.startIndexX = startIndexX;
        this.endIndexX = endIndexX;
        this.startIndexY = startIndexY;
        this.endIndexY = endIndexY;
        this.type = type;
    }
    
    
    //0. Coordenada inicio fin
    //1. Rango x, cordenaday
    //2. COordenada x, rango y
    //3. rango

    @Override
    public Object execute(SymbolTable symbolTable, Canvas currentCanvas) {
        CColor color = currentCanvas.getColors().get((String)idColor.execute(symbolTable, currentCanvas));
        ImageDTO image = null;
        
        for(ImageDTO currentImage : currentCanvas.getTime().getImages()){
            if(currentImage.getId().equals((String)idImage.execute(symbolTable, currentCanvas))){
                image = currentImage;
                break;
            }
        
        }

        if(image == null){
            System.out.println("La imagen no existe");
        }
        else if(color == null){
            System.out.println("El color no existe");
        }
        else{
            int pos;
            int start;
            int end;
            switch(this.type){
                case 0:
                    image.getCanvasPanel().getCells((Integer)posY.execute(symbolTable, currentCanvas) - 1, (Integer)posX.execute(symbolTable, currentCanvas) -1).setBackground(color.getColor());
                break;
                case 1:
                    pos = (Integer)posY.execute(symbolTable, currentCanvas) - 1;
                    start = (Integer)startIndexX.execute(symbolTable, currentCanvas);
                    end = (Integer)endIndexX.execute(symbolTable, currentCanvas);
                    for(int i = start; i <= end; i++){
                        image.getCanvasPanel().getCells(pos, i - 1).setBackground(color.getColor());
                    }
                break;
                case 2:
                    pos = (Integer)posX.execute(symbolTable, currentCanvas) - 1;
                    start = (Integer)startIndexY.execute(symbolTable, currentCanvas);
                    end = (Integer)endIndexY.execute(symbolTable, currentCanvas);
                    for(int i = start; i <= end; i++){
                        image.getCanvasPanel().getCells(i - 1, pos).setBackground(color.getColor());
                    }
                break;
                case 3:
                    
                break;
            }
            
        }
        return null;
    }
    
}
