package Principal;

import javax.swing.JOptionPane;

public class Bingo 
{
	static int MT1 [] [] = new int [6] [6];
	static int MT2 [] [] = new int [6] [6];
	static int MTRep [] [] = new int [6] [6];
	static int MTRep2 [] [] = new int [6] [6];
	static String Jogador1, Jogador2;
	static int Validar = 25, l, c, cont = 0, contv1 = 0, contv2 = 0, num = 0, rep = 0;
	public static void main(String[] args) 
	{
		JOptionPane.showMessageDialog(null, "***********Bingo***********");
		Jogador1 = JOptionPane.showInputDialog("Digite o nome do 1º jogador: ");
		Jogador2 = JOptionPane.showInputDialog("Digite o nome do 2º jogador: ");
		CriarJ();
	}
	
	static void CriarJ()
	{
		for (l = 0; l<=5; l++)
		{
			for (c = 0; c<=5; c++)
			{
				MT1 [l] [c] = (int) ((Math.random()* 49)+1);
				MT2 [l] [c] = (int) ((Math.random()* 49)+1);
			}
		}
		Validar();
	}
	
	static void Validar()
	{
		for ( cont = 0; cont <=25; cont ++)
		{
			for (l=0; l<=5; l++)
			{
				for (c=0; c<=5; c++)
				{
					if (MT1 [l] [c] != MT2 [l] [c])
					{
						Validar = Validar-1;
					}
				}
			}
		}
		if (Validar==25)
		{
			CriarJ();
		}
		else
		{
			Jogo();
		}
	}

	static void Jogo() 
	{
		cont = 0;
		JOptionPane.showMessageDialog(null, "Gerando bilhetes...");
		while(cont<=30)
		{
			cont = cont +1;
			JOptionPane.showMessageDialog(null,
					"***********Bingo***********\n\n"
				   +" " +cont +"ª rodada \n\n"
				   +"|  " +Jogador1  +"   |   "   +Jogador2 +"  |\n\n"
				   +"| "+MT1[1][1] +" " +MT1[1][2] +" " +MT1[1][3] +" " +MT1[1][4] +" " +MT1[1][5]+"  |  "+MT2[1][1] +" " +MT2[1][2] +" " +MT2[1][3] +" " +MT2[1][4] +" " +MT2[1][5] +"| \n"
				   +"| "+MT1[2][1] +" " +MT1[2][2] +" " +MT1[2][3] +" " +MT1[2][4] +" " +MT1[2][5]+"  |  "+MT2[2][1] +" " +MT2[2][2] +" " +MT2[2][3] +" " +MT2[2][4] +" " +MT2[2][5] +"| \n"
				   +"| "+MT1[3][1] +" " +MT1[3][2] +" " +MT1[3][3] +" " +MT1[3][4] +" " +MT1[3][5]+"  |  "+MT2[3][1] +" " +MT2[3][2] +" " +MT2[3][3] +" " +MT2[3][4] +" " +MT2[3][5] +"| \n"
				   +"| "+MT1[4][1] +" " +MT1[4][2] +" " +MT1[4][3] +" " +MT1[4][4] +" " +MT1[4][5]+"  |  "+MT2[4][1] +" " +MT2[4][2] +" " +MT2[4][3] +" " +MT2[4][4] +" " +MT2[4][5] +"| \n"
			       +"| "+MT1[5][1] +" " +MT1[5][2] +" " +MT1[5][3] +" " +MT1[5][4] +" " +MT1[5][5]+"  |  "+MT2[5][1] +" " +MT2[5][2] +" " +MT2[5][3] +" " +MT2[5][4] +" " +MT2[5][5] +"| \n");
			num = (int) ((Math.random()* 49)+1);
			JOptionPane.showMessageDialog(null, "Gerando numero...");
			JOptionPane.showMessageDialog(null, "O numero é: " +num);
			rep = 0;
			for (l= 0; l<= 5; l++)
			{
				for (c = 0; c<=5; c++)
				{
					if (MTRep [l] [c] == num)
					{
						rep++;		
					}
				}
			}
			if (rep>0)
			{
				JOptionPane.showMessageDialog(null, "Numero repetido no bilhete 1, gerando outro");
			}
			else
			{
				for (l = 0; l<=5; l++)
				{
					for (c = 0; c<=5; c++)
					{
						if (MT1[l][c]==num)
						{
							MT1[l][c] = 00;
							contv1 = contv1+1;
							MTRep [l] [c] = num;
						}
					}
				}
			}
			
			rep = 0;
			for (l= 0; l<= 5; l++)
			{
				for (c = 0; c<=5; c++)
				{
					if (MTRep2 [l] [c] == num)
					{
						rep++;		
					}
				}
			}
			if (rep>0)
			{
				JOptionPane.showMessageDialog(null, "Numero repetido no bilhete 2, gerando outro");
			}
			else
			{	
				for (l = 0; l<=5; l++)
				{
					for (c = 0; c<=5; c++)
					{
						if (MT2[l][c]==num)
						{
							MT2[l][c] = 00;
							contv2 = contv2+1;
							MTRep2 [l] [c] = num;
						}
					}
				}
			}
		}
		if (contv1>contv2)
		{
			JOptionPane.showMessageDialog(null, "Fim de jogo, o vencedor é: " +Jogador1);
		}
		else if (contv1<contv2)
		{
			JOptionPane.showMessageDialog(null, "Fim de jogo, o vencedor é: " +Jogador2);
		}
		else if (contv1==contv2)
		{
			JOptionPane.showMessageDialog(null, "Fim de jogo, houve um empate!");
		}
	}	
}