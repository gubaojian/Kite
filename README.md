
###Introduction

Kite is an Simple Android View Layout Extension Framework. Give you powerful view layouting via json layout parameter; which makes layouting view simple and easily. all you need is two step 

1, add json layout parameters with math expression to android:contentDescription or android:tag attribute.
    
    <View
        android:id="@+id/view"  
        ...
        android:contentDescription="{'height':'screen_height*3', 'width':'screen_width - 20dp'}"/>
  or 
  
    <View
        android:id="@+id/view"   
        ...
        android:tag="{'height':'screen_height*3', 'width':'screen_width - 20dp'}"/>

2, call Kite.layout(View v) method, then layout parameters will take effect.
     
     Kite.layout(findViewById(R.id.view));

####1, make view's width = height*0.5 
   
Add android:contentDescription='{"width":"height*0.5"}' to your TextView
  
     <TextView
        android:id="@+id/textview"  
        ...
        android:contentDescription='{"width":"height*0.5"}'/>
        
add Kite.layout(View v) in your code to make the layout parameters take effect     

    Kite.layout(findViewById(R.id.textview)); 

####2, make view's height = 0.5*width  + screen_height/3.0

Add android:contentDescription='{"height":"0.5*width  + screen_height/3.0"}' to your ViewPager
  
     <ViewPager
        android:id="@+id/viewpager"  
        ...
        android:tag='{"height":"0.5*width  + screen_height/3.0"}'/>
        
add Kite.layout(View v) in your code to make the layout parameters take effect         
      
    Kite.layout(findViewById(R.id.viewpager));  

####3, layout view and it's subviews via Kite

with Kite, you can make radio image and square image easily.

	<LinearLayout 
	    android:layout_width="match_parent"
	    android:layout_height="wrap_content"
	    android:orientation="vertical"
	     android:id="@+id/image_container" 
	     >
	    <!-- radio image, height = width*0.5 -->
	    <ImageView
	        android:id="@+id/imageView1"
	        android:layout_width="fill_parent"
	        android:layout_height="wrap_content"
	        android:background="#000fff" 
	        android:contentDescription="{'height':'width*0.5'}"/>
	    <LinearLayout
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content">
	       <!-- square image, height = width -->
	       <ImageView
	        android:id="@+id/imageView1"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:layout_weight="1"
	        android:background="#888000" 
	        android:contentDescription="{'height':'width'}"/> 
	        <!-- square image, height = width -->
	       <ImageView
	        android:id="@+id/imageView1"
	        android:layout_width="wrap_content"
	        android:layout_height="wrap_content"
	        android:layout_weight="1"
	        android:background="#888fff" 
	        android:contentDescription="{'height':'width'}"/> 
	    </LinearLayout>
	</LinearLayout>    

Kite will transverse v, and layout all its subviews, all you need is one line code:

    Kite.layout(findViewById(R.id.image_container));
  

####4, variable you can use in math expression

    height ----> view's height in pixel
    width  ----> view's width in pixel
    parent_height ---> view's parent height in pixel
    parent_width  ---> view's parent width in pixel
    screen_height ---> device screen height in pixel
    screen_width  ---> device screen width in pixel
    density       ---> pixel per one dp
    dp            ---> dp
  
    tips: unit of math expression value is in pixel
    
you can write any valid math expression you like; fox example:
   
    android:contentDescription="{'height':'screen_height*0.8', 'width':'screen_width*0.4 + 10dp'}"        
    android:tag="{'height':'height*0.3', 'width':'screen_width/2.0 - 40dp'}"       
    android:tag="{'height':'height*0.4 + width/2.0', 'width':'parent_height/3.0  + screen_height/2.0'}"  
    
####5, Download Kite
    
Kite use Exp4j as default math expression evaluator. When you use Kite, you need download Exp4j. 

##### [Kite-1.0.0.jar](https://raw.github.com/gubaojian/Kite/master/libs/Kite-1.0.0-SNAPSHOT.jar)

##### [Exp4j-0.3.9.jar](https://raw.github.com/gubaojian/Kite/master/libs/exp4j-0.3.9.jar)

##### Maven

    <dependency>
       <groupId>com.efurture.kite</groupId>
       <artifactId>kite</artifactId>
       <version>1.0.0</version>
    </dependency>
    <dependency>
			<groupId>de.congrace</groupId>
			<artifactId>exp4j</artifactId>
			<version>0.3.9</version>
    </dependency>
    

Kite also support mvel2 as math expression evaluator. just call
 
    Kite.setDefaultEvaluator(new MVEL2Evaluator());
    
if this cann't satisfy you, you can write your own math expression evaluator. 

1, Make subclass of Evaluator 

	public class CustomEvaluator extends Evaluator {
		
		@Override
		protected int evalute(String expression, Map<String, Object> paramsMap) {
		    //do some to get expression value
			return value;
		}
		
	}
	
2, Register your CustomEvaluator to Kite

     Kite.setDefaultEvaluator(new CustomEvaluator());

Exp4j  [http://www.objecthunter.net/exp4j/](http://www.objecthunter.net/exp4j/)

MVEL2  [http://mvel.codehaus.org/](http://mvel.codehaus.org/)  
  
Source code for Kite, its samples, and this website is available on GitHub.

###Bug Reports

you can give suggestions or advice via github or email to me.

Email: gubaojian@163.com

###License
 
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
