class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0,y=0;
        char dir='N';
        for(char c:instructions.toCharArray()){
            switch(c){
                case 'G':
                    if(dir=='N')
                        y++;
                    else if(dir=='E')
                        x++;
                    else if(dir=='S')
                        y--;
                    else
                        x--;
                    break;
                case 'L':
                    if(dir=='N')
                        dir='W';
                    else if(dir=='E')
                        dir='N';
                    else if(dir=='S')
                        dir='E';
                    else
                        dir='S';
                    break;
                case 'R':
                    if(dir=='N')
                        dir='E';
                    else if(dir=='E')
                        dir='S';
                    else if(dir=='S')
                        dir='W';
                    else
                        dir='N';
            }
        }
        return ((x==0 && y==0) || dir!='N');
    }
}