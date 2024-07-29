package com.example.testapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var countryList : ArrayList<Country>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Binding Process Start
        binding = ActivityMainBinding .inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //Binding Process Finish

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val ist = Country("İstanbul",
            "Türkiye, hem Asya hem de Avrupa kıtalarında yer alan bir ülkedir. Başkenti Ankara, en büyük şehri ise İstanbul'dur. Ülkenin zengin tarihi, Bizans ve Osmanlı İmparatorlukları'na ev sahipliği yapmıştır. Ege, Akdeniz ve Karadeniz sahilleri, doğal güzellikler ve tatil olanakları sunar. Kapadokya'nın benzersiz peri bacaları ve Pamukkale'nin sıcak su kaynakları dikkat çeker. Türkiye, mutfağıyla da ünlüdür; kebap, döner ve baklava gibi lezzetler dünya çapında bilinir. Ülke, hem modern hem de geleneksel ögeleri harmanlayarak zengin bir kültürel mozaik sunar. Türkiye, aynı zamanda stratejik bir coğrafi konuma sahiptir.",
            R.drawable.turkiye)
        val par = Country("Fransa",
            "Fransa, Batı Avrupa'da yer alan bir ülkedir ve başkenti Paris'tir. Paris, sanat, moda ve kültürün merkezi olarak bilinir ve Eyfel Kulesi, Louvre Müzesi gibi ünlü simgeleri barındırır. Fransa, tarihi yapıları, güzel köyleri ve şaraplarıyla ünlüdür. Ülke, mutfağıyla tanınır; peynir, şarap ve kruvasan gibi lezzetler dünya çapında bilinir. Fransa'nın etkili bir kültürel mirası vardır; tarihi şatolar ve Gotik katedraller dikkat çeker. Fransa, sanat ve edebiyat alanında önemli katkılar sağlamıştır ve Cannes Film Festivali gibi uluslararası etkinliklere ev sahipliği yapar. Fransa, ayrıca moda ve tasarımda dünya çapında bir üne sahiptir.",
            R.drawable.paris)
        val alm = Country("Almanya",
            "Almanya, Orta Avrupa'da yer alan ve güçlü bir ekonomik yapıya sahip bir ülkedir. Başkenti Berlin olup, diğer büyük şehirleri Münih ve Frankfurt'tur. Almanya, yüksek teknoloji ve mühendislikte öncüdür; özellikle otomobil endüstrisi BMW, Mercedes ve Volkswagen gibi markalarıyla ünlüdür. Ülke, tarihi ve kültürel zenginlikleriyle tanınır; Brandenburg Kapısı ve Neuschwanstein Şatosu gibi yapılar dikkat çeker. Almanya, eğitim ve bilimde de öncüdür; birçok üniversitesi ve araştırma merkezi dünya çapında tanınır. Oktoberfest gibi geleneksel festivalleri ve mutfağı da (özellikle sosisleri ve birası) ünlüdür.",
            R.drawable.almanya)
        val ing = Country("İngiltere",
            "İngiltere, Birleşik Krallık'ın bir parçası olup, başkenti Londra'dır. Tarihi, Shakespeare ve Charles Dickens gibi ünlü yazarlarla doludur. İngiltere, modern finans merkezi olan Londra ile bilinir ve tarihi yapılar arasında Westminster Abbey ve Buckingham Sarayı öne çıkar. Ülke, müzeleri, sanat galerileri ve tiyatro sahneleriyle zengindir. İngiltere'nin geleneksel yemekleri arasında fish and chips ve Yorkshire pudding bulunur. Eğitimdeki prestiji ile Oxford ve Cambridge üniversiteleri dünya çapında tanınır. Ayrıca, İngiltere'nin futbol ligi, Premier League, dünya çapında büyük bir popülariteye sahiptir ve sporun önemli bir parçasıdır.",
            R.drawable.england)
        val usa = Country("Newyork",
            "Amerika Birleşik Devletleri, Kuzey Amerika'da yer alan büyük ve çeşitli bir ülkedir. Başkenti Washington D.C. olup, New York City, Los Angeles ve Chicago gibi büyük şehirleri vardır. ABD, küresel etkisi, kültürel çeşitliliği ve ekonomik gücü ile tanınır. Ülke, Hollywood'un merkezi olarak sinema ve eğlence endüstrisinde öne çıkar. Ayrıca, Silicon Valley, teknoloji ve yenilikte liderdir. ABD'nin uluslararası ilişkilerdeki rolü büyük olup, dünyanın en güçlü ordularından birine sahiptir. Spor kültürü geniştir; Amerikan futbolu, basketbol ve beyzbol popülerdir. ABD, çok çeşitli etnik grupları ve kültürel geçmişleri barındırır.",
            R.drawable.newyork)


        countryList = arrayListOf(ist,par,alm,ing,usa)
        val adapter = CountryAdapter(countryList)
        binding.listCountry.layoutManager = LinearLayoutManager(this)
        binding.listCountry.adapter = adapter
    }
}