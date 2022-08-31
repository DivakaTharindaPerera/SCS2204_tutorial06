object ceaser_ciper{
    var alphabet = Array('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
    def encrypt(letter:Char, shift:Int, i:Int=0):Char=letter match{
        case x if x==alphabet(i) => x match{
            case y if (i+shift)>25 => return alphabet(i+shift-26*((i+shift)/26))
            case _=> return alphabet(i+shift)
        }
        case _=> encrypt(letter,shift,i+1)
    }
    def decrypt(letter:Char, shift:Int, i:Int=0):Char=letter match{
        case x if x==alphabet(i) => x match{
            case y if (i-shift)<0 => {
                return alphabet(26-((shift-i)%26))
                // return alphabet(i-shift-26*((i-shift)/26))
            }
            case _=> return alphabet(i-shift)
        }
        case _=> decrypt(letter,shift,i+1)
    }

    def encrypt_cipher_text(txt:String, shift:Int):String={
        var word ="";
        for (c <- txt){
            word = word + encrypt(c,shift);
        }
        return word;
    }
    def decrypt_cipher_text(txt:String, shift:Int):String={
        var word ="";
        for (c <- txt){
            word = word + decrypt(c,shift);
        }
        return word;
    }
    def main(args:Array[String])={
        println(encrypt_cipher_text("divaka",3));
        println(decrypt_cipher_text(encrypt_cipher_text("divaka",3),3));
    }
}