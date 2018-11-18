package optimal_page_replacement_algorithm_requirement;

import java.util.Arrays;
import java.util.LinkedList;

public class Optimal_Page_Replacement_Algorithm_Requirements {

	
	int page_Hit = 0;
	int free_FramesNumber;
	String[] reference_StringArray;
	
	LinkedList<String> list_ReferenceContainer = new LinkedList<String>();
	
	
	
	public Optimal_Page_Replacement_Algorithm_Requirements( int a, String[] b )
	{
		free_FramesNumber = a;
		reference_StringArray = b;
		
	} //Constructor Optimal_Page_Replacement_Algorithm_Requirements;
	
	
	
	@SuppressWarnings("unused")
	public void Optimal_Output_Calculation()
	{
		
		boolean status_OutputContainer = false;
		String[] OutputContainer = new String[free_FramesNumber];
		
//		System.out.println("\nInside Output Calc.");
		
		//Initializing list_ReferenceContainer with input reference strings;
		for(int i = 0; i < reference_StringArray.length; i++ )
		{
			
			list_ReferenceContainer.addLast( reference_StringArray[i] );
//			OutputContainer[i] = reference_StringArray[i];
//			System.out.println(list_ReferenceContainer);
		}
		
//		System.out.println("reference_StringArray: " + reference_StringArray.length);
		System.out.println();
		System.out.println("Outputs for Optimal page replacement algorithm:");
		System.out.println("--------------------------------------------\n");
		
		for( int i = 0; i < free_FramesNumber; i++ )
		{
			OutputContainer[i] = "";
		}
		
		
		
		
		//-------------------------------
		{
			
//			String temp; // = list_ReferenceContainer.getFirst();
			
//			OutputContainer[0] = temp;
//			list_ReferenceContainer.removeFirst();
			
			
			
			for( int i = 0; i < free_FramesNumber; i++ )
			{
				int match = 0;
				int i_Value = i;
				
				
				String temp = list_ReferenceContainer.getFirst();
				
				for( int j = 0; j < free_FramesNumber; j++ )
				{
				
					if( OutputContainer[j].equals(temp) )
					{
						match = 888;
						i_Value = i;
						++page_Hit;
						list_ReferenceContainer.removeFirst();
						System.out.println("No change...");
						
						
						
						Dispatcher(i, OutputContainer);
						
						break;
					}
				} //End of for( int j = 0; j < free_FramesNumber; j++ );
				
				if(match != 888)
				{
					OutputContainer[i_Value] = temp;
					list_ReferenceContainer.removeFirst();
					
//					System.out.println("Inside !888 ");
					for( int k = 0; k < free_FramesNumber; k++ )
					{
						if( k < (free_FramesNumber-1) )
						{
							System.out.print( OutputContainer[k] + "--" );
						}
						else
						{
							System.out.print( OutputContainer[k] + "" );
						}
						
					}
					System.out.println();
				}
				
				if( list_ReferenceContainer.size() == 0 )
				{
					break;
				}
				
			}
//			System.out.print("Test:: ");
//			for( int i = 0; i < free_FramesNumber; i++ )
//			{
//				System.out.print(i + ": " + OutputContainer[i] + "  ");
//			}
//			System.out.println();
		} //End of void Free_Frames_Initializer();
		//---------------------------------------------
		
		
		
		
		
		
		while( list_ReferenceContainer.size()  != 0 )
		{
			int count_Elements = 0;
			
			for( int i = 0; i < free_FramesNumber; i++ )
			{
				
				//This block executess when all upper conditions are false
				//Scope which only executes when the free frame is fully occupied by elements, not < free frame size;
				
					
				int match = 0;
				int size = free_FramesNumber;
				String temp = list_ReferenceContainer.getFirst();
				
		
				LinkedList<Integer> list_NextElementsContainer = new LinkedList<Integer>();
		
				for( int j = 0; j < free_FramesNumber; j++ )
				{
				
					if( OutputContainer[j].equals(temp) )
					{
						match = 999;
						++page_Hit;
						list_ReferenceContainer.removeFirst();
						System.out.println("No change.");
						
						int index_OfList_ReferenceContainer = Index_FixerForNextInput( OutputContainer );
						
						if( index_OfList_ReferenceContainer == 777 )
						{
							break;
						}
						
						Dispatcher(index_OfList_ReferenceContainer, OutputContainer);
						break;
					}
				} //End of for( int j = 0; j < free_FramesNumber; j++ );
					
					
			
			
				//--------------------------------------------------------	
				if(match != 999)
				{
					
					String temp3 = "";
					int temp4 =  list_ReferenceContainer.size();
					int temp5 = reference_StringArray.length - temp4;
					int index = 0;
					boolean stat = false;
					int a = 0;
					String backup_Element = "";
					
					
					for(int l = 0; l < free_FramesNumber; l++)
					{
						temp3 = OutputContainer[l];
						int temp6 = list_ReferenceContainer.indexOf(temp3);
						
						if( temp6 > 0 )
						{
							list_NextElementsContainer.add(temp6);
						}
						
						else if(temp6 <= 0)
						{
							backup_Element = OutputContainer[l];
						}
						
//							System.out.println(list_NextElementsContainer);
						
					} //End of for(int l = 0; l < free_FramesNumber; l++);
					
					
				
					int length_ListContainer = list_NextElementsContainer.size();
					int[] next_MatchingElementsIndex = new int[length_ListContainer];
				
					
					
					for(int l = 0; l < length_ListContainer; l++ )
					{
						next_MatchingElementsIndex[l] = list_NextElementsContainer.getFirst();
						list_NextElementsContainer.removeFirst();
					}
					
//						System.out.println(next_MatchingElementsIndex.length + ": List Cont. leng.: " + length_ListContainer);
					
					
					//Sorting the indexes to take the first element of first index.
					Arrays.sort(next_MatchingElementsIndex);
					String current_Element = "";// = list_ReferenceContainer.get( next_MatchingElementsIndex[length_ListContainer-1] );
					int index_OfList_ReferenceContainer = 0;
					
//						for(int h = 0; h < next_MatchingElementsIndex.length; h++)
//						{
//								System.out.println(h + " :next_MatchingElementsIndex: " + next_MatchingElementsIndex[h]);
//								System.out.println(list_ReferenceContainer.get( next_MatchingElementsIndex[h] ));
//						}
					
					
					if( next_MatchingElementsIndex.length <= 0 )
					{
						current_Element = list_ReferenceContainer.getFirst();
//							System.out.println(next_MatchingElementsIndex.length + " :Inside <= 0");
					}
					
					else if( next_MatchingElementsIndex.length > 0 )
					{
						int b = length_ListContainer-1;
						current_Element = list_ReferenceContainer.get( next_MatchingElementsIndex[b] );
//							System.out.println(next_MatchingElementsIndex.length + " :Inside > 0");
					}
					
					
//						System.out.println(list_ReferenceContainer.getFirst() + ":Current element: " + current_Element);
					
					if( next_MatchingElementsIndex.length < free_FramesNumber )
					{
						current_Element = backup_Element;
					}
					
					//Saving the index for the element that resides into the queue to replace with newer one
					for( int k = 0; k < free_FramesNumber; k++ )
					{
						if( OutputContainer[k].equals(current_Element) )
						{
							index_OfList_ReferenceContainer = k;
							break;
						}
							
					} //Saving the index for the element that resides into the queue to replace with newer one;
						
						
						//Saving the element into the output array by replacing the older ones
						OutputContainer[index_OfList_ReferenceContainer] = list_ReferenceContainer.getFirst();
						list_ReferenceContainer.removeFirst();
						
						
						//Printing the corresponding outputs
//							System.out.print("OutputContainer[i]:: ");
						for( int k = 0; k < free_FramesNumber; k++ )
						{
							if( k < (free_FramesNumber-1) )
							{
								System.out.print( OutputContainer[k] + "--" );
							}
							else
							{
								System.out.print( OutputContainer[k] + "" );
							}
							
						}
						System.out.println();
//								Print_Output();
						//Printing the corresponding outputs;
					
//						} //End of else if( next_MatchingElementsIndex.length > 0 );
						
						
						
						
					} //End of if(match != 999) condition which executes only with non-redundant values;
					
					
				
				if( list_ReferenceContainer.size() == 0 )
				{
					break;
				}
				
			} //End of for( int i = 0; i < free_FramesNumber; i++ );
			
			
			
			if( list_ReferenceContainer.size() == 0 )
			{
				break;
			}
			
		} //End while( list_ReferenceContainer.size()  != 0 );
		
		
		Double percent = ( ( (double) reference_StringArray.length - page_Hit) / reference_StringArray.length) * 100;
		System.out.println();
		System.out.println();
		System.out.println("Reference string length: " + reference_StringArray.length );
		System.out.println("Page hit: " + page_Hit);
		System.out.println("Page fault number = Total page number - Page hit number");
		System.out.println("Page fault number = " + (reference_StringArray.length - page_Hit) );
		System.out.println("Page fault rate = " + percent + "%" );
		System.out.println();

		
	} //End void FIFO_Output_Calculation() Method;
	//-------------------------------------------------
	
	int Index_FixerForNextInput(String[] OutputContainer)
	{
		String temp3 = "";
		int temp4 =  list_ReferenceContainer.size();
		int temp5 = reference_StringArray.length - temp4;
		int index = 0;
		boolean stat = false;
		int a = 0;
		String backup_Element = "";
		
		LinkedList<Integer> list_NextElementsContainer = new LinkedList<Integer>();
		
		for(int l = 0; l < free_FramesNumber; l++)
		{
			temp3 = OutputContainer[l];
			int temp6 = list_ReferenceContainer.indexOf(temp3);
			
			if( temp6 > 0 )
			{
				list_NextElementsContainer.add(temp6);
			}
			
			else if(temp6 <= 0)
			{
				backup_Element = OutputContainer[l];
			}
			
//				System.out.println(list_NextElementsContainer);
			
		} //End of for(int l = 0; l < free_FramesNumber; l++);
		
		
	
		int length_ListContainer = list_NextElementsContainer.size();
		int[] next_MatchingElementsIndex = new int[length_ListContainer];
	
		
		
		for(int l = 0; l < length_ListContainer; l++ )
		{
			next_MatchingElementsIndex[l] = list_NextElementsContainer.getFirst();
			list_NextElementsContainer.removeFirst();
		}
		
//			System.out.println(next_MatchingElementsIndex.length + ": List Cont. leng.: " + length_ListContainer);
		
		
		//Sorting the indexes to take the first element of first index.
		Arrays.sort(next_MatchingElementsIndex);
		String current_Element = "";// = list_ReferenceContainer.get( next_MatchingElementsIndex[length_ListContainer-1] );
		int index_OfList_ReferenceContainer = 0;
		
//			for(int h = 0; h < next_MatchingElementsIndex.length; h++)
//			{
//					System.out.println(h + " :next_MatchingElementsIndex: " + next_MatchingElementsIndex[h]);
//					System.out.println(list_ReferenceContainer.get( next_MatchingElementsIndex[h] ));
//			}
		
		if( list_ReferenceContainer.size() == 0 )
		{
			return 777;
		}
		
		
		if( next_MatchingElementsIndex.length <= 0 )
		{
			current_Element = list_ReferenceContainer.getFirst();
//				System.out.println(next_MatchingElementsIndex.length + " :Inside <= 0");
		}
		
		else if( next_MatchingElementsIndex.length > 0 )
		{
			int b = length_ListContainer-1;
			current_Element = list_ReferenceContainer.get( next_MatchingElementsIndex[b] );
//				System.out.println(next_MatchingElementsIndex.length + " :Inside > 0");
		}
		
		
//			System.out.println(list_ReferenceContainer.getFirst() + ":Current element: " + current_Element);
		
		if( next_MatchingElementsIndex.length < free_FramesNumber )
		{
			current_Element = backup_Element;
		}
		
		//Saving the index for the element that resides into the queue to replace with newer one
		for( int k = 0; k < free_FramesNumber; k++ )
		{
			if( OutputContainer[k].equals(current_Element) )
			{
				index_OfList_ReferenceContainer = k;
				break;
			}
				
		} //Saving the index for the element that resides into the queue to replace with newer one;
	
	
		return index_OfList_ReferenceContainer;
		
	} //End of int Index_FixerForNextInput(String[] OutputContainer) Mrthod;
	
	

	
	
	
	
	
	//------------------------------
	void Dispatcher( int i, String[] OutputContainer)
	{
//		System.out.println("Inside Dispatcher");
		

		String temp = "";
		int flag = 0;

		if( list_ReferenceContainer.size() == 0 )
		{
			return;
		}
		
		temp = list_ReferenceContainer.getFirst();
		
		
		
		for( int j = 0; j < free_FramesNumber; j++ )
		{
			if( OutputContainer[j].equals(temp) )
			{
				list_ReferenceContainer.removeFirst();
				
				++page_Hit;
				System.out.println("No change");
				
				int index_Value = Index_FixerForNextInput(  OutputContainer );
				
				Dispatcher(index_Value, OutputContainer);
//				System.out.println("Dispatcher: "+i+" Val: "+OutputContainer[j]);
				flag = 999;
				break;
			}
		}
			
		if( list_ReferenceContainer.size() == 0 )
		{
			return;
		}
			
		if(flag != 999)
		{
			OutputContainer[i] = list_ReferenceContainer.getFirst();
//			System.out.println("Bottom-Dispatcher: "+i+" Under Outp. Container: "+OutputContainer[i]);
			list_ReferenceContainer.removeFirst();
			
			
			for( int k = 0; k < free_FramesNumber; k++ )
			{
				if( k < (free_FramesNumber-1) )
				{
					System.out.print( OutputContainer[k] + "--" );
				}
				else
				{
					System.out.print( OutputContainer[k] + "" );
				}
				
			}
			System.out.println();
		}
		
		return;
		
		
	} //End of void Dispatcher( int i, String[] OutputContainer);
	
	
	
	
	
} //End of public class Optimal_Page_Replacement_Algorithm_Requirements;
