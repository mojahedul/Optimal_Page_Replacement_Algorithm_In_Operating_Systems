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
	public void FIFO_Output_Calculation()
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
			
		
		while( list_ReferenceContainer.size()  != 0 )
		{
			int count_Elements = 0;
			
			for( int i = 0; i < free_FramesNumber; i++ )
			{
				for( int j = 0; j < free_FramesNumber; j++ )
				{
					status_OutputContainer = OutputContainer[j].isEmpty();
					
					if(status_OutputContainer == true)
						break;
				}
				
//				//To count the number of elements exist in the string array, not blank.
//				for( int j = 0; j < free_FramesNumber; j++ )
//				{
//					status_OutputContainer = OutputContainer[j].isEmpty();
//					
//					if(status_OutputContainer == false)
//					{
//						++count_Elements;
//					}
//				} //Counting numbers;
				
				
//				if( count_Elements == 0)
//				{
//					System.out.println("Inside if() ");
//					
//					OutputContainer[i] = list_ReferenceContainer.getFirst();
//					list_ReferenceContainer.removeFirst();
//					
////					System.out.print("OutputContainer[i]:: ");
//					for( int j = 0; j < free_FramesNumber; j++ )
//					{
//						if( j < (free_FramesNumber-1) )
//						{
//							System.out.print( OutputContainer[j] + "--" );
//						}
//						else
//						{
//							System.out.print( OutputContainer[j] + "" );
//						}
//				
//					}
//					System.out.println();
//					
////					Print_Output();
//				} //End of if( status_OutputContainer == true && count_Elements == 0) condition;
				
				
				if( status_OutputContainer == true  )
				{
//					System.out.println("Inside if(): " + count_Elements);
					
					OutputContainer[i] = list_ReferenceContainer.getFirst();
					list_ReferenceContainer.removeFirst();
					
//					System.out.print("OutputContainer[i]: ");
					for( int j = 0; j < free_FramesNumber; j++ )
					{
						if( j < (free_FramesNumber-1) )
						{
							System.out.print( OutputContainer[j] + "--" );
						}
						else
						{
							System.out.print( OutputContainer[j] + "" );
						}
				
					}
					System.out.println();
					
				} //End of else if( status_OutputContainer == false && count_Elements < free_FramesNumber );
				
				
				
				//This block executess when all upper conditions are false
				//Scope which only executes when the free frame is fully occupied by elements, not < free frame size;
				else
				{	
//					System.out.println("Inside else():" );
					
					int match = 0;
					int size = free_FramesNumber;
					String temp = list_ReferenceContainer.getFirst();
					
			
					LinkedList<Integer> list_NextElementsContainer = new LinkedList<Integer>();
			
				for( int j = 0; j < free_FramesNumber; j++ )
					{
					
						if( OutputContainer[j].contains(temp) )
						{
							match = 999;
							++page_Hit;
							list_ReferenceContainer.removeFirst();
							
//							int[] next_MatchingElementsIndex = new int[free_FramesNumber];
//							String temp3 = list_ReferenceContainer.getFirst();
//							int temp4 =  list_ReferenceContainer.size();
//							int temp5 = reference_StringArray.length - temp4;
//							int index = 0;
//							boolean stat = false;
//							int i_Value = 0;
//							
//							
//							
//							//Loop to find the index of elements resides into queue
//							for(int k = temp5; k < reference_StringArray.length; k++)
//							{
//								if(reference_StringArray[k].equalsIgnoreCase( OutputContainer[j] ) )
//								{
//									next_MatchingElementsIndex[index] = list_ReferenceContainer.indexOf(OutputContainer[j] );
//									++index;
//									stat = true;
//									i_Value = j;
//									break;
//								}
//								
//							} //Loop to find the index of elements resides into queue;
//							
//						}
//							
//							//Sorting the indexes to take the first element of first index.
//							Arrays.sort(next_MatchingElementsIndex);
//							String current_Element = list_ReferenceContainer.get( next_MatchingElementsIndex[0] );
//							int index_OfList_ReferenceContainer = 0;
//							
//							
//							//Saving the index for the element that resides into the queue to replace with newer one
//							for( int k = 0; k < free_FramesNumber; k++ )
//							{
//								if( OutputContainer[k] == current_Element )
//								{
//									index_OfList_ReferenceContainer = k;
//									break;
//								}
//									
//							} //Saving the index for the element that resides into the queue to replace with newer one;
//							
//							list_ReferenceContainer.removeFirst();
//							Dispatcher(index_OfList_ReferenceContainer, OutputContainer);
//							
//							
////							System.out.print("OutputContainer[i]:: ");
//							for( int k = 0; k < free_FramesNumber; k++ )
//							{
//								if( k < (free_FramesNumber-1) )
//								{
//									System.out.print( OutputContainer[k] + "--" );
//								}
//								else
//								{
//									System.out.print( OutputContainer[k] + "" );
//								}
//								
//							}
//							System.out.println();
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
					
					
				} //End of else() scope which only executes when the free frame is fully occupied by elements, not < free frame size;
				
				
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
	
	
	
	
	
	
	//------------------------------
	void Dispatcher( int i, String[] OutputContainer)
	{
		System.out.println("Inside Dispatcher");
		
//		int size = OutputContainer.length;
		String temp = "";
		int flag = 0;

//		if( list_ReferenceContainer.size() != 0 )
//		{
//		System.out.println("list_ReferenceContainer.size(): " + list_ReferenceContainer.size());
			temp = list_ReferenceContainer.getFirst();
//		}
		
		
		
		for( int j = 0; j < free_FramesNumber; j++ )
		{
			if( OutputContainer[j].equals(temp) )
			{
				list_ReferenceContainer.removeFirst();
				
				++page_Hit;
				Dispatcher(i, OutputContainer);
//				System.out.println("Dispatcher: "+i+" Val: "+OutputContainer[j]);
				flag = 999;
				break;
			}
		}
			
		if( list_ReferenceContainer.size() == 0 )
		{
//			System.out.println("\nError occured.. System exiting.\tError code 401");
			System.exit(1);
		}
			
		if(flag != 999)
		{
			OutputContainer[i] = list_ReferenceContainer.getFirst();
//			System.out.println("Bottom-Dispatcher: "+i+" Under Outp. Container: "+OutputContainer[i]);
			list_ReferenceContainer.removeFirst();
		}
		
		
		
		
		
//				Print_Output(OutputContainer);
			
			
//		} //End of for( int j = 0; j < size; j++ );
		
	} //End of void Dispatcher( int i, String[] OutputContainer);
	
	
	
	
	
} //End of public class Optimal_Page_Replacement_Algorithm_Requirements;
