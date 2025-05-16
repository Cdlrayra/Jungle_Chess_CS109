package model;

public class Pieces {
    private int owner;
    private char name;
    private int rank;


    public Pieces() {
    }

    public Pieces(int owner, char name, int rank) {
        this.owner = owner;
        this.name = name;
        this.rank = rank;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    public boolean isCatch(Pieces target){//是否可以捕获该目标
        if(this.owner==target.owner){return false;}

        if(this.rank==1&&target.rank==8){//todo:还不完善，老鼠在河里也不能吃大象
            return true;
        }
        if(this.rank==8&&target.rank==1){
            return false;
        }
        if(this.rank>=target.rank){
            return true;
        }
        //todo:如果老鼠进入河流，均不能被捕捉，也不能捕捉岸上的大象
        return false;
    }
    public boolean isRiver(){//是否可以渡河
        if(this.rank==7||this.rank==6){return true;}
        //todo:如果老鼠进入河流，该直线上不能渡河
        return false;
    }
    public boolean isIntoRiver(){//是否可以进入河流
        if(this.rank==1){return true;}
        return false;
    }
}
