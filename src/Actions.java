
public class Actions { 
	Bird object = new Bird();
public void main(String args []) 
{ 
	int score = 0;
	if (object.keyboard == true) 
	{ 
		object.jump = true;  
		//make jump its own class
		object.height += 50;
	}  
	if (object.collision == true) 
	{ 
		object.dead = true;
	} 
	else 
	{ 
		score++;
	} 
	//Once the player gets past the score of 100, make the pipes move
}
}