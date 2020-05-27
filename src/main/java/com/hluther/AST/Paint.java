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
        }
        else{
            this.startIndexY = startIndex;
            this.endIndexY = endIndex;
            this.posX = pos;
        
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
            switch(type){
                case 0:
                    image.getCanvasPanel().getCells((Integer)posY.execute(symbolTable, currentCanvas) - 1, (Integer)posX.execute(symbolTable, currentCanvas) -1).setBackground(color.getColor());
                break;
                case 1:
                    int y = (Integer)posX.execute(symbolTable, currentCanvas) - 1;
                    for(int i = (Integer)startIndexX.execute(symbolTable, currentCanvas); i <= (Integer)endIndexX.execute(symbolTable, currentCanvas); i++){
                        System.out.println("Dentro del for");
                        image.getCanvasPanel().getCells(i - 1, y).setBackground(color.getColor());
                    }
                break;
                case 2:
                    for(int i = (Integer)startIndexY.execute(symbolTable, currentCanvas); i <= (Integer)endIndexY.execute(symbolTable, currentCanvas); i++){
                        image.getCanvasPanel().getCells((Integer)posY.execute(symbolTable, currentCanvas) - 1, i - 1).setBackground(color.getColor());
                    }
                break;
                case 3:
                    
                break;
            }
            
        }
        return null;
    }
    
}
