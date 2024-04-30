#include "STORAGE.h"

STORAGE::STORAGE(string filename)
{
    puzzle.resize(4 , vector<int>(4));
    ifstream inputfile(filename);
    if (inputfile.is_open)
        {
            string lstring;//
            int rownum;//
            string puzzleValue[4]
            while(getline(inputFile,lstring))
            {
                if(rownum==4)
                {
                    //
                    initialiser(puzzleValue);
                    puzzles.push_back(puzzle);
                    row=0;
                }
                else
                {
                    initialiser(rownum)=lstring;
                    row++
                }
            }
            if(rownum==4)
                {
                    //
                    initialiser(puzzleValue);
                    puzzles.push_back(puzzle);
                    row=0;
                }
                inputfile.close;
        }

}
void STORAGE :: printPuzzle()
{
    cout<<endl;
    for(int i = 0 ; i< 4;i++)
    {
        for(int j =0 ; j<4 ; j++)
        {
            for(int k = 0 ; k< 4 ; k++)
            {
               cout <<puzzles[i][j][k]<< " " <<;
            }
            cout<<endl;
        }
        cout<<endl;
    }
}

void STORAGE::getpuzzles()
{
    return numOfPuzzles;
}

vector<vector<vector<int>>>getpuzzles() STORAGE::getpuzzles()
void STORAGE::initialiser(string stringline[4])
{

    for (int i= 0;i <4 ; i++)
    {
        string tempNum ;
        int clmn =0;
        for (int j =0 ; j< 4 ; j ++)
            {

                if (stringline[i][j] != '' && j <= stringline[i].length())
                    {
                        tempNum = tempNum + stringline[i][j];
                        if( j ==stringline[i].length()-1)
                        {
                            stringline[i][clmn] = stoi(tempNum);
                        }

                }
                else
                    {
                        stringline[i][clmn] = stoi(tempNum);
                        clmn++;
                        tempNum = " ";


                    }
            }

    }

}
