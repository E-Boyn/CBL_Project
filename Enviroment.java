public class Enviroment {
    Card[] enviromentArray;
    
    int numOfobjects;

    Enviroment(int round){

        if(round == 0){
            numOfobjects = 4;

            int numOfTree = randomNumber(numOfobjects);
            numOfobjects = numOfobjects - numOfTree;

            int numOfHouse = randomNumber(numOfobjects);
            numOfobjects = numOfobjects - numOfHouse;

            int numOfCave = randomNumber(numOfobjects);


                for(int i = 0; i < numOfTree ; i++){
                    new Tree();
                }
                for(int i = 0; i < numOfHouse ; i++){
                    new House();
                }
                for(int i = 0; i < numOfCave ; i++){
                    new Cave();
                }
        } 
    }
    
    private int randomNumber(int num){
        return (int) ((Math.random() * (num - 1)) + 1);
    }
}

