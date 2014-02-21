Kite
====

Simple Android View Layout Extension Framework

##Introduction

Kite is an Android View Layout Extension, give you power for sizing view by simple math expression; which makes layout view simple and easily. you can use kite in any view without modify view component code. All you need is the following two step 

1、 add json format math expression layout parameters to android:contentDescription or android:tag
    
    <View
        android:id="@+id/view"
        ...
        android:contentDescription='{"screen_width*3 + parent_height*0.3"}'/>

2、 can Kite.layout(View v) method
     
     Kite.layout(findViewById(R.id.view));

##Quick Start

###1, Make View's width = height*0.5 
   
Add android:contentDescription='{"width":"height*0.5"}' to your TextView
  
     <TextView
        android:id="@+id/textview"
        ...
        android:contentDescription='{"width":"height*0.5"}'/>
        
add Kite.layout(View v) in your code to make the attribute take effect     

    Kite.layout(findViewById(R.id.textview)); 

###2, Make View's height = 0.5*width  + screen_height/3.0

Add android:contentDescription='{"height":"0.5*width  + screen_height/3.0"}' to your ViewPager
  
     <ViewPager
        android:id="@+id/viewpager"
        ...
        android:contentDescription='{"height":"0.5*width  + screen_height/3.0"}'/>
        
add Kite.layout(View v) in your code to make the attribute take effect          
      
    Kite.layout(findViewById(R.id.viewpager));  
    
###3, Layout View Via Tag Attribute
you can also layout view via android:tag attribute
    
     <TextView
        android:id="@+id/textview"
        ...
        android:tag='{"width":"height*0.5"}'/>
        
    <ViewPager
        android:id="@+id/viewpager"
        ...
        android:tag='{"height":"0.5*width  + screen_height/3.0"}'/>

add Kite.layout(View v) method in your code to make the attribute take effect
     
    Kite.layout(findViewById(R.id.textview));    
    
    Kite.layout(findViewById(R.id.viewpager));  


###4, Support Auto Handle Layout For All Subviews 

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

Kite will transverse v, and handle it's all subviews, all you need is one line code:

    Kite.layout(findViewById(R.id.image_container));
  

###5, Variable you can use in math expression

    height ----> view's height in pixel
    width  ----> view's width in pixel
    parent_height ---> view's parent height in pixel
    parent_width  ---> view's parent width in pixel
    screen_height ---> device screen height in pixel
    screen_width  ---> device screen width in pixel
    density       ---> pixel per one dp
    dp            ---> dp
  
    tips: unit of math expression value is in pixel
    
you can write any valid math expression you like. fox example:
   
      screen_width/2.0 - 40dp 
      parent_height/3.0  + screen_height/2.0

###6, Write your own math expression provider.

1, Make Subclass of ExpressionProvider

	public class CustomEvaluator extends Evaluator {
		
		@Override
		public int evalInt(String expression, Map<String, Object> paramsMap) {
			return 0;
		}
		
	}
	
2, Register your CustomExpressionProver  

     Kite.setDefaultEvaluator(new CustomEvaluator());
<br/>    
##Download


### Kite-1.0.0.jar

### Exp4j-0.3.9.jar

#### MAVEN

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
    
    
Kite use Exp4j as default math expression evaluator. When you use Kite, you need down Exp4j. 

Kite also support mvel2 as math expression evaluator. just set call
 
    Kite.setDefaultEvaluator(new MVEL2Evaluator());
    
if this cann't satisfy you, you can write your own math expression evaluator. 

Source code for Kite, its samples, and this website is available on GitHub.

<br/>
##Bug Reports

you can give suggestions or advice via github or email to me.

Email: gubaojian@163.com

<br/>
##License
 
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
	You may obtain a copy of the License at
	
	   http://www.apache.org/licenses/LICENSE-2.0
	
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
