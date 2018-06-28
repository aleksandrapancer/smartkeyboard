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
		
		keyboardHook.addKeyListener(new GlobalKeyAdapterImpl());
		return keyboardHook;

        }

    private static class GlobalKeyAdapterImpl extends GlobalKeyAdapter {

        public GlobalKeyAdapterImpl() {
        }

        @Override public void keyPressed(GlobalKeyEvent event) {
            try {
                System.out.println(event);
                Robot robot = new Robot();
                
                if(helpValue == 0){
                    {
                        Map<Character, String> charMap = GlobalKeyboardExample.keyboardHook.getCharMap();
                        int virtualCode = event.getVirtualKeyCode();
                        if(charMap.containsKey((char)virtualCode))                                        {
                            robot.keyPress(GlobalKeyEvent.VK_BACK);
                            
                            String mappedKeys = charMap.get((char) virtualCode);
                            for (int i = 0; i < mappedKeys.length(); i++){
                                char c = mappedKeys.charAt(i);
                                
                                    switch(c){
                                        case '!' :
                                            robot.keyPress(KeyEvent.VK_SHIFT);
                                            robot.keyPress(KeyEvent.VK_1);
                                            robot.keyRelease(KeyEvent.VK_1);
                                            robot.keyRelease(KeyEvent.VK_SHIFT);
                                            helpValue++;
                                            helpValue++;
                                            break;
                                        case '?' :
                                            robot.keyPress(KeyEvent.VK_SHIFT);
                                            robot.keyPress(KeyEvent.VK_SLASH);
                                            robot.keyRelease(KeyEvent.VK_SLASH);
                                            robot.keyRelease(KeyEvent.VK_SHIFT);
                                            helpValue++;
                                            helpValue++;
                                            break;
                                        case 'Ó':
                                            robot.keyPress(KeyEvent.VK_ALT);
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_O);
                                            //
                                            robot.keyRelease(KeyEvent.VK_O);
                                            robot.keyRelease(KeyEvent.VK_ALT);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            helpValue++;
                                            helpValue++;
                                            helpValue++;
                                            break;
                                        case 'Ę':
                                            robot.keyPress(KeyEvent.VK_ALT);
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_E);
                                            //
                                            robot.keyRelease(KeyEvent.VK_E);
                                            robot.keyRelease(KeyEvent.VK_ALT);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            helpValue++;
                                            helpValue++;
                                            helpValue++;
                                            break;
                                                    
                                        case 'Ą':
                                            robot.keyPress(KeyEvent.VK_ALT);
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_A);
                                            //
                                            robot.keyRelease(KeyEvent.VK_A);
                                            robot.keyRelease(KeyEvent.VK_ALT);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            helpValue++;
                                            helpValue++;
                                            helpValue++;
                                            break;
                                            
                                        case 'Ł':
                                            robot.keyPress(KeyEvent.VK_ALT);
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_L);
                                            //
                                            robot.keyRelease(KeyEvent.VK_L);
                                            robot.keyRelease(KeyEvent.VK_ALT);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            helpValue++;
                                            helpValue++;
                                            helpValue++;
                                            break;
                                            
                                        case 'Ś':
                                            robot.keyPress(KeyEvent.VK_ALT);
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_S);
                                            //
                                            robot.keyRelease(KeyEvent.VK_S);
                                            robot.keyRelease(KeyEvent.VK_ALT);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            helpValue++;
                                            helpValue++;
                                            helpValue++;
                                            break;
                                            
                                        case 'Ć':
                                            robot.keyPress(KeyEvent.VK_ALT);
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_C);
                                            //
                                            robot.keyRelease(KeyEvent.VK_C);
                                            robot.keyRelease(KeyEvent.VK_ALT);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            helpValue++;
                                            helpValue++;
                                            helpValue++;
                                            break;
                                            
                                        case 'Ż':
                                            robot.keyPress(KeyEvent.VK_ALT);
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_Z);
                                            //
                                            robot.keyRelease(KeyEvent.VK_Z);
                                            robot.keyRelease(KeyEvent.VK_ALT);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            helpValue++;
                                            helpValue++;
                                            helpValue++;
                                            break;
                                            
                                        case 'Ź':
                                            robot.keyPress(KeyEvent.VK_ALT);
                                            robot.keyPress(KeyEvent.VK_CONTROL);
                                            robot.keyPress(KeyEvent.VK_X);
                                            //
                                            robot.keyRelease(KeyEvent.VK_X);
                                            robot.keyRelease(KeyEvent.VK_ALT);
                                            robot.keyRelease(KeyEvent.VK_CONTROL);
                                            helpValue++;
                                            helpValue++;
                                            helpValue++;
                                            
                                        default:
                                            robot.keyPress(c);
                                            robot.keyRelease(c);
                                            helpValue++;
                                    }
   
                            }
                            
                            helpValue++;
                        }
                    }
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
    }
}