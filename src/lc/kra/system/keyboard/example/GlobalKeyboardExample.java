/**
 * Copyright (c) 2016 Kristian Kraljic
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package lc.kra.system.keyboard.example;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.BreakNode;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

public class GlobalKeyboardExample {
	private static boolean run = true;
        static int helpValue;
        static GlobalKeyboardHook keyboardHook;
	public static void main(String[] args) {
		GlobalKeyboardHook keyboardHook = runHook();
                
                		try {
			while(run) Thread.sleep(128);
		} catch(InterruptedException e) { /* nothing to do here */ }
		  finally { keyboardHook.shutdownHook(); }
	}
        
        public static GlobalKeyboardHook runHook()
        {
            // might throw a UnsatisfiedLinkError if the native library fails to load or a RuntimeException if hooking fails 
		keyboardHook = new GlobalKeyboardHook(true); // use false here to switch to hook instead of raw input
                helpValue = 0;
                
		System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");
		for(Entry<Long,String> keyboard:GlobalKeyboardHook.listKeyboards().entrySet())
			System.out.format("%d: %s\n", keyboard.getKey(), keyboard.getValue());
		
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override public void keyPressed(GlobalKeyEvent event) {
                            try {
                                System.out.println(event);                               
                                Robot robot = new Robot();
                                
                                if(helpValue == 0){
                                    {
                                        Map<Character, String> charMap = GlobalKeyboardExample.keyboardHook.getCharMap();
                                        int virtualCode = event.getVirtualKeyCode();
                                        if(charMap.containsKey((char)virtualCode))                                        {                                            robot.keyPress(GlobalKeyEvent.VK_BACK);
                                            //r.delay(100);
                                            String mappedKeys = charMap.get((char) virtualCode);
                                            for (int i = 0; i < mappedKeys.length(); i++){
                                                char c = mappedKeys.charAt(i);

                                                if(c == 'Ę' ||
                                                   c == 'Ą' ||
                                                   c == 'Ó' ||
                                                   c == 'Ć' ||  
                                                   c == 'Ś' ||
                                                   c == 'Ź' ||
                                                   c == 'Ż')
                                                {
                                                    switch(c){
                                                        case 'Ę':
                                                        //robot.keyPress(KeyEvent.VK_ALT_GRAPH);
                                                        //robot.keyPress(KeyEvent.VK_E);
                                                        //robot.keyRelease(KeyEvent.VK_E);
                                                        //robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
                                                        robot.keyPress(KeyEvent.VK_E);
                                                        break;
                                                        case 'Ą':
                                                        robot.keyPress(KeyEvent.VK_A);
                                                        break;
                                                        default:
                                                        robot.keyPress(KeyEvent.VK_X);    
                                                        break;                                   
                                                    }
                                                                                                            robot.keyPress(KeyEvent.VK_COMMA);
                                                        helpValue++;
                                                        helpValue++;
                                                        break;  
                                                }
                                                else
                                                {
                                                    robot.keyPress(c); 
                                                    robot.keyRelease(c); 
                                                    helpValue++;
                                                    //helpValue++;
                                                }                                              
                                            //Process char
                                            }
   
                                            helpValue++;
                                            
                                        }
                                    }
                                //}
                        //else if(helpValue == 2){
                        //            helpValue=0;
                                }else{
                                    helpValue--;
                                }
                                
                            } catch (AWTException ex) {
                                Logger.getLogger(GlobalKeyboardExample.class.getName()).log(Level.SEVERE, null, ex);
                            }
				if(event.getVirtualKeyCode()==GlobalKeyEvent.VK_ESCAPE)
					run = false;
			}
			@Override public void keyReleased(GlobalKeyEvent event) {
                            System.out.println(event);
                                }
		});
		return keyboardHook;

        }
}