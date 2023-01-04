class Solution {

    public long solution(long price, long money, long count) {

        return (price = (count*(count+1)/2)*price)<=money? 0: price-money;
    }
}
