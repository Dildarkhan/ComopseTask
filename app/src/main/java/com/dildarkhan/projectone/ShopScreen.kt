package com.dildarkhan.projectone

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showSystemUi = true)
@Composable
fun ShopScreen() {
    val products = mutableListOf<Product>(
        Product(R.drawable.insta_icon,
            "Clencera",
            "French clay and algae-powered cleanser",
            "Skin Tightness - Dry & Dehyrated Skin",
            "RS.355.20",
            "RS. 444.00",
            true,
            true,
            true,
            5,
            249),
        Product(R.drawable.insta_icon,
            "glow",
            "French clay and algae-powered cleanser",
            "Skin Tightness - Dry & Dehyrated Skin",
            "RS.355.20",
            "RS. 444.00",
            true,
            false,
            false,
            5,
            249),
        Product(R.drawable.insta_icon,
            "afterglow",
            "French clay and algae-powered cleanser",
            "Skin Tightness - Dry & Dehyrated Skin",
            "RS.355.20",
            "RS. 444.00",
            false,
            false,
            false,
            5,
            1249)
        )

    val categories = mutableListOf<Category>(
        Category(R.drawable.product_image,"Cleaners"),
        Category(R.drawable.product_image,"Toner"),
        Category(R.drawable.product_image,"Serums"),
        Category(R.drawable.product_image,"Moisturisers"),
        Category(R.drawable.product_image,"Sun Cream"),
        Category(R.drawable.product_image,"Toner"),
        Category(R.drawable.product_image,"Serums"))

    Column(
      modifier = Modifier
          .fillMaxSize()
          .background(colorResource(R.color.gray_900))
    ){
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        CategorySection(categories)
        NewProductsSection(products)
    }
}

@Composable
fun Header() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Surface(color = Color.Transparent, modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.shopflowcard1), // Replace with your drawable name
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
                    .background(color = Color.Transparent)
            )


           Column(modifier = Modifier.padding(start = 40.dp, top = 30.dp, end = 30.dp, bottom = 30.dp)) {
                Text(
                    "Get 20% OFF",
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
               Spacer(modifier = Modifier.height(16.dp))
               Text("Get 20% off", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.W300)
               Spacer(modifier = Modifier.height(30.dp))
               Text("12-15 October", color = Color.Black, fontSize = 10.sp, fontWeight = FontWeight.W300,
                   modifier = Modifier.padding(bottom = 16.dp)
                       .background(color = colorResource(R.color.light_greenA400),
                       shape = RoundedCornerShape(14.dp))
                       .clip(RoundedCornerShape(14.dp)).padding(5.dp) )
            }
        }
    }
}

@Composable
fun CategorySection(categories:List<Category>) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("Categories", color = Color.White,
            fontFamily = FontFamily(Font(R.font.century_old)) ,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Text("See all", modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(end = 10.dp),
            textDecoration = TextDecoration.Underline,
            color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Normal)

    }
    LazyRow {
        items(categories){category->
            CategoryItem(category)
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun CategoryItem(category: Category) {
    Surface(modifier = Modifier.padding(top = 10.dp, start = 10.dp, bottom = 10.dp, end = 0.dp), color = Color.Transparent) {
        Column() {
            Image(
                painter = painterResource(R.drawable.product_image), contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(65.dp)
                    //.align(alignment = Alignment.TopStart)
                    //.padding(start = 16.dp, top = 12.dp, bottom = 1.dp, end = 0.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = 30.dp.toPx(),
                            center
                        )
                    }
            )
            //Spacer(modifier = Modifier.height(8.dp))
            Text(category.type, color = Color.White, fontWeight = FontWeight.Light, modifier = Modifier.fillMaxWidth().align(alignment = Alignment.CenterHorizontally))
        }
    }
}


@Composable
fun NewProductsSection(products:List<Product>) {
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text("New products", color = Color.White,
            fontFamily = FontFamily(Font(R.font.century_old)) ,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp)
                .weight(1f)
                .align(Alignment.CenterVertically)
        )
        Text("See all", modifier = Modifier
            .align(Alignment.CenterVertically)
            .padding(end = 10.dp),
            textDecoration = TextDecoration.Underline,
            color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Normal)

    }


    LazyColumn {
        items(products){product->
            //ProductItem(product)
            ProductItemCard(product)
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun ProductTitleCard(product: Product) {
    Box(
        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 16.dp)
    ){
        Surface (color = Color.Transparent){
            Image(
                painter = painterResource(id = R.drawable.product_title_card), // Replace with your drawable name
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()
                    .background(color = Color.Transparent)
            )
            Image(painter = painterResource(R.drawable.cart3), contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .border(1.dp, colorResource(R.color.light_greenA400), CircleShape,)
                    .size(48.dp)
                    .clip(CircleShape)
                    .align(alignment = Alignment.BottomEnd)
                    .padding(12.dp)
                    .background(color = Color.Transparent)
                    //.matchParentSize()
                    //.padding(start = 0.dp, top = 1.dp, bottom = 12.dp, end = 20.dp)


            )
            Column(modifier = Modifier.padding(16.dp)) {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(product.brand, modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                        fontFamily = FontFamily(Font(R.font.tangerine)),
                        color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    if(product.inStock){
                        Text("*In Stock" , modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Green, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    }else{
                        Text("*Out of stock" , modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.Red, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                    }
                }
                Spacer(modifier = Modifier.height(7.dp))
                Text(product.detail, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.W300 )
                Spacer(modifier = Modifier.height(7.dp))
                Text(product.description, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.W600 )
                Spacer(modifier = Modifier.height(7.dp))
                Row {
                    Text(product.offerPrice,
                        color = colorResource(R.color.light_purple), fontSize = 16.sp, fontWeight = FontWeight.W600 )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(product.actualPrice,
                        color = Color.Gray, fontSize = 16.sp, fontWeight = FontWeight.Normal, textDecoration = TextDecoration.LineThrough )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Row {
                    RatingBar(
                        rating = product.ratingStart.toFloat(),
                        starSize = 18.dp,
                        onRatingChanged = { newRating ->
                            var rating = newRating
                        }
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text("${product.reviewCount} reviews", color = Color.White,
                        fontFamily = FontFamily(Font(R.font.neuzeitsltstdbook)),
                        fontSize = 14.sp, fontWeight = FontWeight.W300, textDecoration = TextDecoration.Underline )
                }
            }
        }


    }

}

//@Preview(showSystemUi = true)
@Composable
fun ProductItemCard(product: Product) {
    Box(
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Surface(color = Color.Transparent) {
            Image(
                painter = painterResource(id = R.drawable.product_bg_card), // Replace with your drawable name
                contentDescription = "Background Image",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.FillBounds
            )
            Image(
                painter = painterResource(if(product.isFav) R.drawable.fav_icon else R.drawable.fav_icon_border), contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(36.dp)
                    .align(alignment = Alignment.TopStart)
                    .padding(start = 16.dp, top = 12.dp, bottom = 1.dp, end = 0.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color.Black,
                            radius = 18.dp.toPx(),
                            center
                        )
                    }
            )
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 70.dp),
            ){

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    Image(painter = painterResource(R.drawable.product_image), contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(250.dp)
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                ProductTitleCard(product)
                /*Box(modifier = Modifier.align(alignment = Alignment.BottomCenter)){
                    ProductTitleCard()
                }*/


            }
        }

    }
}


@Composable
fun ProductItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray.copy(alpha = 0.1f))
            .padding(16.dp)
    ) {
        Image(painter = painterResource(/*id = product.imageRes*/R.drawable.insta_icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
        )


        /*Text(product.brand, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Yellow)
        Text(product.description, fontSize = 12.sp, color = Color.White)
        Text(product.price, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Green)
        Button(
            onClick = {},
            enabled = product.inStock,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(if(product.inStock) "Add to Card" else "Out of Stock")
        }*/
    }
}

data class Product(
    val imageRes:Int,
    val brand:String,
    val detail:String,
    val description: String,
    val offerPrice:String,
    val actualPrice:String,
    val inStock:Boolean,
    val isFav:Boolean,
    val isBestSeller:Boolean,
    val ratingStart:Int,
    val reviewCount:Int
)
data class Category(
    val imageRes:Int,
    val type:String,
)