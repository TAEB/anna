package annahack.telnetconnection;

public class ConsoleInstruction
{
	private boolean ischaracter;
	private boolean islongcommand=false;
	private boolean movex=true;
	private boolean movey=true;
	//private boolean scrollx=false;
	//private boolean scrolly=false;
	
	private byte character=0;
	private byte char2=0;
	private byte char3=0;
	private int x=0;
	private int y=0;
	
	private int index;
	
	public ConsoleInstruction(byte[] instr, int i)
	{
		index=i;
		
		character=instr[index++];
		ischaracter=character!=27;
		if (!ischaracter)
		{
			char2=instr[index++];
			islongcommand=char2=='[';
			if (!islongcommand)
			{
				switch (char2)
				{
				case 'M':
					x=-1;
					break;
				default:
					throw new RuntimeException("ESC "+char2+" not supported");
				}
			}else{
				char2=instr[index++];
				switch (char2)
				{
				case 'H':
				case 'f':
					movey=true;
					break;
				default:
					char3=instr[index++];
					switch (char3)
					{
					case 'A':
						x=-char2;
						break;
					case 'B':
						x=char2;
						break;
					case 'C':
						y=char2;
						break;
					case 'D':
						y=-char2;
						break;
					case ';':
						x=char2;
						y=instr[index++];
						char3=instr[index++];
						switch (char3)
						{
						case 'H':
						case 'f':
							movex=false;
							movey=false;
							break;
						default:
							throw new RuntimeException("ESC [ "+x+";"+y+" "+char3+" not supported");	
						}
						break;
					default:
						throw new RuntimeException("ESC [ "+char2+" "+char3+" not supported");
					}
				}
			}
		}
	}
	
	public int nextIndex()
	{
		return index;
	}
	
	public boolean isCharacter(){return ischaracter;}
	public boolean moveX()		{return movex;		}
	public boolean moveY()  	{return movey;		}
//	public boolean scrollX()	{return scrollx;	}
//	public boolean scrollY()	{return scrolly;	}
	public int getX()			{return x;			}
	public int getY()			{return y;			}
	
	public byte character()
	{
		return character;
	}
	
}
