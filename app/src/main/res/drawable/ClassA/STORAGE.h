#ifndef STORAGE_H_INCLUDED
#define STORAGE_H_INCLUDED

#include<iostream>
#include<fstream>
#include<string>
#include<vector>

using namespace std;

class Storage {
public:
    //Initialise a constructor
    Storage(){};
    Storage(string filename); //A constructor to read the input file
    void printPuzzle();

    //Getters
    int getpuzzlevalue();
    vector<vector<vector<int>>>getpuzzles();



private:
    int numOfPuzzles; //Variable to help determine the number of puzzles
    vector<vector<int>>puzzle; //Using a vector to store the 4by4 puzzle
    vector<vector<vector<int>>>puzzles;
    void initialiser(string stringline[4]);

};



#endif // STORAGE_H_INCLUDED
