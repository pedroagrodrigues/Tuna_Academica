import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    // Declaração de Variáveis
    private World world; // Guarda o Mundo Da Opção Selecionada.
    private boolean mouseOver = false; //Verefica Se o "Rato" está num dos Botões/Opções do Menu.
    
    /**
     * Construtor Menu: Define cada "Opção" de Acordo com Tipo de Dados  Recebido.
     */
    public Button(int type, double worldHeight)
    {
        switch (type){
            case 0:
                setImage(new GreenfootImage("oneButton.png"));
                getImage().scale((int)(worldHeight/4),(int) (worldHeight/6));
                world = new OnePlayer();
                break;
            case 1:
                world = new TwoPlayers();
                setImage(new GreenfootImage("twoButton.png"));
                getImage().scale((int)(worldHeight/4),(int) (worldHeight/6));
                break;
            case 2:
                 setImage(new GreenfootImage("exitButton.png"));
                 getImage().scale((int)(worldHeight/7),(int) (worldHeight/7));      
                break;
                
        }
      
    }
   
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Reajusta Tamanho da Opção para 90% do Seu Tamanho Original.
        if(Greenfoot.mouseMoved(this) && !mouseOver){
            getImage().scale(getImage().getWidth()*90/100, getImage().getHeight()*90/100);
            mouseOver = true;
        }            
        // Chama o Mundo se a Opção Foi Selecionada.
        if(Greenfoot.mouseClicked(this))
            placeWorld();
        // Faz Opção Retroceder/ Voltar ao Tamanho Original.
        if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this) && mouseOver){
            getImage().scale(getImage().getWidth()*100/90,getImage().getHeight()*100/90);
            mouseOver = false;
        }
 
    }
    
    /**
     * Método Criado Para Definir a Função de Cada Opção Do Menu.
     */
    private void placeWorld()
    {
        if(world != null){
            Greenfoot.setWorld(world);
        }
        else
            Greenfoot.stop();
    }
}
